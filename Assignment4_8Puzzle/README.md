# Specification
Here is the link of assignment specification:  
http://coursera.cs.princeton.edu/algs4/assignments/8puzzle.html

# My solution
### Board
#### API
```java
public class Board {
    public Board(int[][] blocks)           // construct a board from an n-by-n array of blocks
                                           // (where blocks[i][j] = block in row i, column j)
    public int dimension()                 // board dimension n
    public int hamming()                   // number of blocks out of place
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    public boolean isGoal()                // is this board the goal board?
    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    public boolean equals(Object y)        // does this board equal y?
    public Iterable<Board> neighbors()     // all neighboring boards
    public String toString()               // string representation of this board (in the output format specified below)

    public static void main(String[] args) // unit tests (not graded)
}
```
This one is well defined and implementation is straightforward, see more 
[here](https://github.com/CtheSky/Algorithms-Coursera/blob/master/Assignment4_8Puzzle/Board.java)  
One more thing to mention, we should use `getClass` instead of `instanceof` when implementing `equals`, otherwise 
it won't pass the style check. Here is a good discussion on 
[stackoverflow](http://stackoverflow.com/questions/4989818/instanceof-vs-getclass)

  
### Solvor
#### API
```java
public class Solver {
    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    public boolean isSolvable()            // is the initial board solvable?
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    public static void main(String[] args) // solve a slider puzzle (given below)
}
```
First we have to create an inner class to store information of every guess we made:  
```java
private class Node implements Comparable<Node> {
        private Board board;
        private Node previous;// Keep track of movements
        private int moves;

        public Node(Board board, Node previous, int moves) {
            this.board = board;
            this.previous = previous;
            this.moves = moves;
        }

        public int compareTo(Node that) {
            return this.board.manhattan() + this.moves - that.board.manhattan() - that.moves;
        }
    }
```
Don't put a neighbor of a board into `Priority Queue` if it's same as previous of that board, it's critical otherwise
this algorithm may not end. 
See more [here](https://github.com/CtheSky/Algorithms-Coursera/blob/master/Assignment4_8Puzzle/Solver.java)
