# 2052 - Number Steps

## Problem Description
You are given a plane where non-negative numbers (0, 1, 2, ...)
starting at point (0,0) alternate between two lines y = x and y = x + 2,
going from left to right.
You are to write a program that reads the coordinates of a point (x, y),
and writes the number (if any) that has been written at that point.
(x, y) coordinates in the input are in the range 0 . . . 5000.

## Solution Explanation
This is a mathematics type problem. To find the number at each point,
we first check if the difference between x and y coordinates is less than
or equal to 2. If that's the case, then there are 4 possible cases:
1. x and y are both even. then the number at (x,y) is x+y.
2. x and y are both odd, then the number at (x,y) is x+y-1.
3. x is even and y is odd, then there is no number at (x,y).
4. x is odd and y is even, then there is no number at (x,y).

If the difference between x and y is greater than 2, then we know that
the point is out of the bounds of the two graph lines, so there is
no number at that point.

To check if a number n is even, mod by 2 and check if the result is 0: n % 2 == 0
To check if a number n is odd, mod by 2 and check if the result is 1: n % 2 == 1

Another way to solve this problem is to use brute force.
The brute force solution would be to create a 5000x5000 2D int array
to represent the graph, but this unnecessarily wastes space,
so is not recommended.

## [Link](https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=53)