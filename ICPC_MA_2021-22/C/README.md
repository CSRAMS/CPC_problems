[Full problem description](https://mausa21.kattis.com/problems/concertrehearsal)

**Incomplete -- Solution is probably algorithmically sound, but way too slow.  Based on the constraints, some kind of mathematical shortcut is
necessary**

**Problem Topics**: Number theory? Modular arithmetic
**Problem Difficulty Estimate**: Hard?

**Input**: Number of students, time concert hall is open per day, number of days.

**Output**: How many full rehearsal passes can the class complete in k days?

**Approach**: In competition we tried the above solution, which repeatedly iterates through student performances for the total number of days, given
that they stop for the day if there isn't enough time for the next performance.  This got a TLE -- there can be up to 10 billion days with a CPU time
limit of 1 second -- some kind of mathematical shortcut is necessary.
