[Full problem description](https://mausa21.kattis.com/problems/espresso)

**Problem Type**: Ad-hoc  
**Problem Difficulty Estimate**: Easy

**Input**: Water tank size in oz, a number of espresso orders, and a list of order sizes (in oz's of water).

**Output**: Give how many times the tank needs to be refilled if the tank *must* be refilled every time the next order exceeds the amount of water left, 
and if the orders are filled in the same sequence given in the input.

**Approach**: We simply iterate through the orders and keep track of how much water is left in the tank.  If the upcoming order exceeds the amount of water left,
we refill the tank, increment the number of refills, and then subtract the order size from the water remaining in the newly full tank.
