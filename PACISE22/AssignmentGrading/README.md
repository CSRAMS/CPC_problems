[Full Problem Description](https://www.codechef.com/PACE2022/problems/PACISE9)

**Problem Topics**: ad-hoc

**Problem Difficulty**: Easy

**Input**: A line with `T`, the number of testcases. The number of testcases follows:
- A line with space-separated integers `N`, the number of "assignments"; `P`, the position of the target assignment in the queue; `X`, the minutes to grade a freshman's assignment; and `Y`, the minutes to grade a senior's assignment
- A line with `N` space-separated integers `A_1` to `A_n`, either `0` or `1`

**Output**: The number of minutes passed once the target assignment is complete.

**Approach**:
1. For each testcase, grab the input variables.
2. For each assignment up to and including the target, add `X` to the total if the assignment is a `1`, `Y` if the assignment is a `0`.
3. Print the total.