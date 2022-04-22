# 2400 - Starship Hakodate-maro

## Problem Description
Given the number fuel balls that can be supplied, calculate the maximum number
of fuel balls to request. The number of fuel balls requested should be a
combination of a cubic number (n\*n\*n) and a tetrahedral number
(n(n+1)(n+2)/6) for some n = 0, 1, 2, ... so as to fit into the two
fuel containers of the surveyor starship, Hakodate-maro.
If the number of fuel balls supplied is 0, end the program.

## Solution Explanation
This is a brute force problem. Use a nested for loop to try all possible
combinations of cubic and tetrahedral numbers whose sum is less than or
equal to the number of fuel balls supplied. Then, print the max number
of fuel balls that can be requested.

## [Link](https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=7&page=show_problem&problem=401)