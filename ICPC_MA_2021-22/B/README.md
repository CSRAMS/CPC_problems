[Full problem description](https://mausa21.kattis.com/problems/ultimatebinarywatch)

**Problem Topics**: Ad-hoc, binary, decimal-binary conversion.  
**Problem Difficulty Estimate**: Easy

**Input**: Time of day in 24 hr format.

**Output**: Binary watch face with input time as displayed in problem output examples.

**Approach**: 

  - Parse digits from input number
  - convert these digits to binary
  - display these digits in the specified format on the output clockface
 
Here we parsed input digits using division and modulus (could also parse from String).  Then we constructed entries in each output column (representing a digit 
on the clock face) by iteratively dividing the number by 2,checking if it is >8,4,2,1 to determine whether each of these bits should be set, and then subtracting
the value of that bit from the number if it is set.  This is a variant of a standard algorithm for converting decimal to binary:
 
 Given a decimal number n and an array a to store binary digits:
 
     for(i=0;n>0;i++) {    
         a[i]=n%2;    
         n=n/2;    
     }  
 
 Asserting that we check 8,4,2,1 rather than using the general algorithm is one of several approaches to ensuring that we include leading zeros for the output.
 An alternative approach for binary conversion could be to use a case-switch/dictionary, returning a different array for each of the 10 possible digits -- is practical in this case because there are only 10 possible cases.
 
 It was important to be mindful of the exact spacing specifications described for the output. 
