# Specification

Here is the link of assignment specification:  
http://coursera.cs.princeton.edu/algs4/assignments/kdtree.html

# My solution
## PointSET
#### API
```java
public class PointSET {
   public         PointSET()                               // construct an empty set of points 
   public           boolean isEmpty()                      // is the set empty? 
   public               int size()                         // number of points in the set 
   public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
   public           boolean contains(Point2D p)            // does the set contain point p? 
   public              void draw()                         // draw all points to standard draw 
   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle 
   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty 

   public static void main(String[] args)                  // unit testing of the methods (optional) 
}
```
The implementation is straightforward, 
see more [here](https://github.com/CtheSky/Coursera-Algorithms/blob/master/Assignment5_KdTrees/PointSET.java)

## KdTree
#### API
```java
public class KdTree {
   public         PointSET()                               // construct an empty set of points 
   public           boolean isEmpty()                      // is the set empty? 
   public               int size()                         // number of points in the set 
   public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
   public           boolean contains(Point2D p)            // does the set contain point p? 
   public              void draw()                         // draw all points to standard draw 
   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle 
   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty 

   public static void main(String[] args)                  // unit testing of the methods (optional) 
}
```
For `insert`, make sure it handles duplicate points correctly.  
For `range`, prune tree if rectangle is on the other side.  
For `nearest`, arrange the call to subtrees, make the other side be called later which gives a chance to prune it.  
For `draw`, course video doesn't talk a lot about `StdDraw`, but it's well documented:
```java
 public void draw() {
        // draw all points to standard draw
        draw(root);
    }

    private void draw(Node x) {
        if (x == null) return;
        StdDraw.setPenColor(StdDraw.BLACK);
        x.point.draw();
        if (x.divideBy == VERTICAL) {
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.line(x.point.x(), 0, x.point.x(), 1);
        } else {
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.line(0, x.point.y(), 1, x.point.y());
        }
    }
```
See more [here](https://github.com/CtheSky/Coursera-Algorithms/blob/master/Assignment5_KdTrees/KdTree.java)

