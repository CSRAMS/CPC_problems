Min Cost Climbing Stairs:

We can do this in O(n) time by applying principles of dynamic programming - breaking the problem down into subproblems and saving the work as we go.  Specifically, we can save the minimum cost to reach the top of the staircase for every step, starting from the top.  Consider the following example:

	cost =  [3,6,2,8,10,5,4]

The cost to reach the top from index -1 can only possibly be 4, as this is the last step.  We can save this value in the variable next2 in the code.  Next, we consider the minimum cost to reach the top from index -2.  We can take 1 or 2 steps from here.  

	Taking 1 step gives: cost[-2]+next2 = 5+4 = 9

	Taking 2 steps gives: cost[-2] = 5 — if we take two steps we reach the top.  

Therefore, the minimum of our two options gives a cost of 5 to reach the top of the steps from this point.  We can save this value in the variable next in the code.  

Next we consider the minimum cost from index -3.  Once again, this will be the cost at the index plus the minimum cost of taking one or two steps.  We have saved the minimum cost of taking one step in next, and the minimum cost of taking two steps in next2.  Therefore:

	Min_cost(-3) = cost[-3] + min(next, next2) = 10+min(5,4) = 14.

We can save this value in the variable cur in the code, and update next2 to next and next to cur.

We can now simply repeat these steps for each index i in cost[] - sourcing the minimum cost for each step from the minimum of the following 2 costs we have stored:

 	int cur =cost[i]+Math.min(next,next2);
           next2 = next;
           next = cur;  


Delete and Earn

For every delete operation (of nums[i]) we need to find all elements equal to nums[i]+1 and nums[i]-1, so we begin by sorting nums to make this an ~ O(1) operation rather than an O(n) operation.  Now consider the following sorted instance of nums:

	[2,2,3,3,3,4,4,5,5,6,6,7,7,9,9,10]

We know that a delete operation of nums[i] will delete all entries equal to nums[i]+1 and nums[i]-1, but will retain all entries equal to nums[i].  For example, if we delete the first 6, all of the fives and sevens will be removed, but all of the sixes will be retained.  Thus, there is never a case where we need to inspect groups of equal values individually as opposed to collectively, so subarrays of consecutive values can be simplified into sums of equal values:

	2,2 -> 4
	3,3,3 -> 9
	4,4 -> 8 …etc.

Values that are not directly consecutive to the previous index can be treated as a new subarray, as they will never be affected by the deletion of prior values in the array, and vice versa.  In this example, there is a gap between the 7’s and the 9’s, so we can break nums into two subarrays of sums of equal values: 2…7, and 9…10.  This yields:

	[4,9,8,10,12,14], [18,10]

The problem is now reduced to finding the maximum sum of elements at nonconsecutive indices in each subarray.  This is exactly the same problem as Leetcode #198 - House Robber, which we did last week.  We want to iterate through the array and store the maximum possible sum (given the constraint of using no two consecutive indices) through the current index.  This ultimately necessitates a lookback of only 2 elements at any given point.  In the code, we store the maximum through the previous element in prev_max, and the maximum through the element before that as prev2_max.  Doing this on the first subarray:  

	The maximum through the first index is 4: prev_max = 4.
	The maximum through the second index is 9: prev_max = 9, prev2_max = 4.  
	At index 3, the maximum is max(prev2_max+nums[3], prev_max).  In this case it is 	prev2_max+nums[3]=12 > prev_max =9.
	We save this value in cur_max and update prev_max and prev2_max.  By saving the maxes as we go, we only ever need to consider 3 values to determine the max at the next index:

	[prev2_max, prev_max, cur_max, …next]

We know that cur_max can’t contribute to the max at next, so the main question in each iteration is whether prev_max or prev2_max is greater.
Because we are only restricted to not using directly consecutive indices, it never makes sense to skip more than 2 elements, thus a lookback of more than two is never required.  

Once we’ve gotten the maximum sum for each subarray, we simply add them together, yielding a final result for the entire initial nums array.


Jump Game II:

Valid but naive solution (almost certainly a better way):

We start from the back of the array, and iterate to the front, storing the mimimum number of jumps to reach the end as we go.  If a position is not within direct reach of the end, we look at all positions that are in range, and take the minimum jumps to the end out of those.   
