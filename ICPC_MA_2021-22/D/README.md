[Full problem description](https://mausa21.kattis.com/problems/landequality)

**Problem Topics**: Ad-hoc  
**Problem Difficulty Estimate**: Medium

**Input**: Number of rows and columns in plot of land, grid of numbers representing prosperity of each cell.

**Output**: Give the minimum possible difference in prosperity (defined as product of cells) if the land is split into two contiguous pieces.

**Approach**: The multiplicative nature of the propserity score saves us from having to explicitly account for the arrangement of the cells in most cases.
As long as the land has >1 rows and >1 columns (minimum 4 cells), we can derive the minimum prosperity difference (MPD) simply from the counts of each type 
of cell.  The MPD largely hinges on the number of 0s and 2s in the land, since multiplying by 1 leaves a prosperity score unchanged.
 
 Cases (with at least 2 rows and at least 2 columns):
 
   No 0s:
     If there are no 0s, we can count the 2s:
     
       If there are no 2s, the MPD is 0, as all cells are 1.

       If there is one 2, all other values must be 1, making the MPD 1.  

       If there are two or more 2s, 1s don't matter because they simply multiply a prosperity value by 1, leaving it unchanged.  In this case,
       if there is an even number of 2s, the minimum prosperity difference (MPD) is 0.  If there is an odd number of 2s, the MPD is 
       2^(`num_twos`/2+1)-2^(`num_twos`/2).  (Do the prosperity score calculation for each descendent and take the difference).  
     
  One 0: 
    This means one descendant will have a prosperity score of 0.  We therefore want to minimize the other prosperity score as much as possible.  
    We can do this by giving the descedent with the 0 all but a signle cell.  The other descendent will therefore either have a 1 or 2, which will 
    simply be the minimum available in the land grid.  
    
  Two or more 0s:
    Each descendent gets a zero, making the MPD 0.  
 
Only one row or column:
  When the land is a 1d array, we lose some of the geometric flexibility in drawing a split in the land we get with a 2d array -- 
  MPD can no longer be calculated simply by counting types of cells.  For these cases, we checked every split in the array and found the minimum 
  resulting MPD.  This works, as only up to 63 splits have to be made.  
  
**Tricky edge case**: MPD and some derivative calculations must be done using longs, as if there are more than 60 2s in the array, the prosperity score
for at least one of the descendant's land will exceed Java's Integer max value (2^31-1).  Finding this edge case was half the difficulty of the problem
for me.  
    
      
