[Article on LCS](https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/)

@auther - Nolan
Here's 3 implementations of LCS. The first, `recur_lcs` is the naive, recursive approach. Easy to think about, but not very quick. Uses `O(2^n)` time and constant space.

The second implementation is a straight iterative dynamic programming approach. It is much quicker than recursive; however in Python, the overhead to create a full 2d matrix doubles the time. Uses `O(2 * (len(s1) * len(s2))` time and `O((len(s1) + 1) * (len(s2) + 1))` space. The matrix starts as a bunch of 0s, then is built from the bottom up. There is one extra row and column to avoid wraparound with the list indices. Start the loops at index 1 to avoid looping needlessly.

The third implementation has similar logic to the second, but uses much less space (and less time in Python). This is also the preferred approach of the theory article linked above. Uses `O(len(s1) * len(s2))` time and `O(2 * (len(s2) + 1))` space. The 2d loop only cares about the current item and the items left, up, and diagonally left and up (if imagining a 2d matrix), so the current and previous rows only are needed.
