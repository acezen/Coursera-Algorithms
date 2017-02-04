#Specification

Here is the link of assignment specification:  
http://coursera.cs.princeton.edu/algs4/assignments/seamCarving.html


#My Solution
There are two optimizations I made:  
  1. use `int` 2d array to represents graph, saves time by avoiding construct explicit DirectedEdge and EdgeWeightedDigraph objects.
  2. use `int` to store `Color`:
    - `Color` has four fields r, g, b and alpha
    - each ranges from 0 ~ 255, which takes 8 bits
    - it's reasonable to store them in an `int` (32bits for 4-8bits)
    - standard library support this optimization well, see implementation of `java.awt.Color`
