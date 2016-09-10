# Specification
Here is the link of assignment specification:  
http://coursera.cs.princeton.edu/algs4/assignments/collinear.html
  
# My solution
### Point
#### API
```java
public class Point implements Comparable<Point> {
   public Point(int x, int y)                         // constructs the point (x, y)

   public void draw()                                 // draws this point
   public void drawTo(Point that)                     // draws the line segment from this point to that point
   public String toString()                           // string representation

   public int compareTo(Point that)                   // compare two points by y-coordinates, breaking ties by x-coordinates
   public double slopeTo(Point that)                  // the slope between this point and that point
   public Comparator<Point> slopeOrder()              // compare two points by slopes they make with this point
}
```
#### Implementation
Our task is to implement last three methods. They are well defined in documentation, so this part is straightfroward 
and see more [here](https://github.com/CtheSky/Algorithms-Coursera/blob/master/Assignment3_CollinearPoints/Point.java)

### BruteCollinearPoints
#### API
```java
public class BruteCollinearPoints {
   public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   public           int numberOfSegments()        // the number of line segments
   public LineSegment[] segments()                // the line segments
}
```
#### Implementation
This part has been simplified by following words:
> The method segments() should include each line segment containing 4 points exactly once.
> If 4 points appear on a line segment in the order p→q→r→s,
> then you should include either the line segment p→s or s→p (but not both) 
> and you should not include subsegments such as p→r or q→r. For simplicity,
> we will not supply any input to BruteCollinearPoints that has 5 or more collinear points. 

So we don't have to deal with duplicate case, and time complexity is allowed to be N4:   
>  Performance requirement. The order of growth of the running time of your program should be
> N4 in the worst case and it should use space proportional to n plus the number of line segments returned.

One more thing to pay attention to is that we shouldn't change original array. See more 
[here](https://github.com/CtheSky/Algorithms-Coursera/blob/master/Assignment3_CollinearPoints/BruteCollinearPoints.java)

### FastCollinearPoints
#### API
```java
public class FastCollinearPoints {
   public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
   public           int numberOfSegments()        // the number of line segments
   public LineSegment[] segments()                // the line segments
}
```
#### Implementation
This time we have to care about a line containing 5 or more points, we should avoid counting duplicate `LineSegment`.
I sort the point and only count it when it's the min point in line.
See more [here](https://github.com/CtheSky/Algorithms-Coursera/blob/master/Assignment3_CollinearPoints/FastCollinearPoints.java)
