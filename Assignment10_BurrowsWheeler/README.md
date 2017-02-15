#Specification

Here is the link of assignment specification:  
http://coursera.cs.princeton.edu/algs4/assignments/burrows.html


#My Solution
Missing 2 points on performance of `MoveToFront` and `CircularSuffixArray`:  

Used a linkedList to implement `MoveToFront`, complexity is close,"4.27e-07 * N^0.92  (R^2 = 1.00)", but ont good enough.

Used a fake suffix string class for `CircularSuffixArray`, tried `Quick3String` but caused stackoverflow when alphabet was small,
finally chose MSD as implementation.
