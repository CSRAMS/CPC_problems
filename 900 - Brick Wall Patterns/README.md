# 900 - Brick Wall Patterns

## Problem Description
You are given a plane where non-negative numbers (0, 1, 2, ...)
starting at point (0,0) alternate between two lines y = x and y = x + 2,
going from left to right.
You are to write a program that reads the coordinates of a point (x, y),
and writes the number (if any) that has been written at that point.
(x, y) coordinates in the input are in the range 0 . . . 5000.

## Solution Explanation
This is a mathematics type problem.
The solution involves using Fibonacci numbers.

Given a wall of length n, the number of different patterns for such a wall
is exactly equal to the (n+1)th fibonacci number.

To calculate the nth fibonacci number, we can do 3 things:
1. Iteratively calculate the number using a loop.
2. Use recursion to calculate the number.
3. Use [Binet's formula](http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html#:~:text=We%20have%20only%20defined%20the,task%2C%20even%20with%20a%20calculator!).

The third option is the best among the three. Using Binet's formula,
we can quickly calculate the nth fibonacci number.
Time complexity: O(1) (constant time)
Space complexity: O(1) (constant space)

## [Problem Link](https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=11&page=show_problem&problem=841)
