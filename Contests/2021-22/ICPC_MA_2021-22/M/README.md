[Full problem description](https://mausa21.kattis.com/problems/streamlag). 

**Problem Topics**: Ad-hoc  
**Problem Difficulty Estimate**: Easy

**Input**: Integer representing number of packets followed by the series of packets, each with its position in the
sequence of all packets and the time at which it arrives.

**Output**: Give the total lag time i.e. the total time which the stream is not playing because the next packet hasn't arrived yet.

**Approach**: 
  - Parse the packets into an ArrayList of 1d arrays of length 2, each holding the position and arrival time of the packet.
  - Sort these packets by the order in which they are supposed to arrive.  We didn't know of a trivial way to do this in Java,
  so we just reimplemented quicksort from a textbook, sorting by the first index of the packet arrays.
  - Iterate through the sorted packets while also keeping track of the stream's elapsed time, `curTime`.  For each packet we increment `curTime` by 1
  for the 1 second it takes to display.  If a packet's arrival time is later than `curTime`, we increment `curTime` by the difference between `curTime`
  and the packet's arrival time.  We also increment the total lag by this amount, as the stream cannot continue during these times.  At the end we return the total lag time.  
