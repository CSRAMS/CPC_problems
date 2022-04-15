
[Full problem description](https://www.codechef.com/PACE2022/problems/PACISE8/)

**Problem Topics**: ad-hoc
**Problem Difficulty Estimate**: Easy

**Input**: Some number of input sets each with:

-An integer `n`, representing the number of mascots
- one line with two integers: x and y coordinates of the quarterback
- `n` lines each with two integers: the x and y coordinates of a mascot

**Output**: For each input set, print the smallest radius that hits the most mascots. 

**Approach**: Iterate through the mascots in each input set, seeing which integer rope radius would hit them.  We use the 
decimal of the radius to see whether the rope radius should be above or below the radius to the mascot (given that each mascot occupies a radius of 
+/- 0.5 around its coordinates).  Then update the number of mascots for this rope radius in a hashmap.  We update the rope radius that hits the most mascots
on every iteration.  If the radius on the current iteration is equal to the best radius, we take the smaller radius as the best radius per the problem specification.

**Note**: This problem (and some others in this set) required very close reading to get, partially because of typos and vagueries.  It's always important
to understand *exactly* what the problem is asking for.  
