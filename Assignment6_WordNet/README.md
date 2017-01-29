#Specification

Here is the link of assignment specification:  
http://coursera.cs.princeton.edu/algs4/assignments/wordnet.html

#My Solution
There are two optimizations I did in `SAP` class:  
  1. reimplement BFS to run two BFS in synchronized layer for two synsets, 
so when current found common ancestor length is smaller than the length of current layer, there is no need to compute those vertices.  

  2. reuse array to save time of initialization, to do this I reset changed value after finished running bfs.

Two optimizations are enough to pass the 4 bonus tests, 
see more in [code](https://github.com/CtheSky/Coursera-Algorithms/blob/master/Assignment6_WordNet/SAP.java).

Also I found this link very useful: [Frequently Asked Questions](http://coursera.cs.princeton.edu/algs4/checklists/wordnet.html)
