
[Full problem description](https://www.codechef.com/PACE2022/problems/PACISE7)

**Problem Topics**: ad-hoc  
**Problem Difficulty Estimate**: Easy

**Input**:
- An integer `p`, <= 10000 representing the number of "problems"
- a double representing the initial radius of our sphere
- `p` lines with three doubles representing the length, width, and height, respectively of a box.

**Output**: Whether or not the problemset needs to be "rebuilt"

**Approach**: We iterate through the "problems" (boxes) in the input, representing each of them as an array of length 3 holding its dimensions.  We store all
the boxes in an ArrayList, and then sort the list by the height of the box from smallest to largest.  Because the sphere must have a higher center of mass
than a box to collect it, if it reaches a box with a higher COM than it in the *sorted* list, there is no way we can further expand to eventually be able to
collect this box, since *all* subsequent boxes also have higher COMs than our current sphere.  In this case we print ""We need to rebuild this! ".  Otherwise,
if we iterate through the entire list of boxes and all have been collected, we print "It's going to be a good set! ".  We customized a quicksort algorithm
from a textbook to sort the arraylist by height of the boxes.  
 
