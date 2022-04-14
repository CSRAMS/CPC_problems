[Full problem description](https://www.codechef.com/PACE2022/problems/PACISE2_1)

**Problem Topics**: Ad-hoc  
**Problem Difficulty Estimate**: Easy

**Input**: 1-19 character PACISE ID number.  

**Output**: Output "VALID" or "INVALID" based on the evaluation criteria given in the problem description.  

**Approach**: Iterate through the digits of the number, doubling them in the specified pattern.  If a digit is doubled, we add the resultant digits to an 
overall sum.  If not, we simply add the original digit to the overall sum.  We then check if the overall sum mod 10 is 0.  
