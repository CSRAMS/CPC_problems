[Full problem description](https://mausa21.kattis.com/problems/bracketpairing)

**Incomplete - solution is algorithmically sound but too slow.**

**Problem Topics**: Stack, recursive backtracking  
**Problem Difficulty Estimate**: Medium-hard

**Input**: A string of brackets (4 types, both open and close) and question marks, signifying any type of bracket.  Length up to 20 characters.

**Output**:  Give the number of possible valid bracket sequences that can be derived from the input string. 

**Approach**: 

We iterate through the input string, pushing open brackets to the stack, popping them when we encounter matching close brackets, and terminating when we find an invalid bracket.  When we encounter a question mark, we make recursive calls to try every possible open bracket.  After trying all the open brackets, we make a recursive call to place the close bracket matching the open bracket on top of the stack.  We also prune by only allowing the placing of open brackets if the remaining characters in the input string is greater than the open brackets on the stack (all of these need to be closed out).  This gets a TLE on Kattis - We need a more efficient approach.
