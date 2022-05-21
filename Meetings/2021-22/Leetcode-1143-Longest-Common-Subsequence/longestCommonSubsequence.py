import time

def recur_lcs(s1, s2): # O(2^n) time, O(1) space
    if len(s1) * len(s2) == 0:
        return 0
    elif s1[-1] == s2[-1]:
        return 1 + recur_lcs(s1[:-1], s2[:-1])
    else:
        return max(recur_lcs(s1[:-1], s2), recur_lcs(s1, s2[:-1]))

def iter1_lcs(s1, s2): # O(2 * (len(s1) * len(s2))) time, O((len(s1) + 1) * (len(s2) + 1)) space
    rows = len(s1) + 1
    cols = len(s2) + 1
        
    dp = [[0] * cols for _ in range(rows)]
        
    for i in range(1, rows):
        for j in range(1, cols):
            if s1[i - 1] == s2[j - 1]:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        
    return dp[-1][-1]

def iter2_lcs(s1, s2): # O(len(s1) * len(s2)) time, O(2 * (len(s2) + 1)) space
    rows = len(s1) + 1
    cols = len(s2) + 1
        
    cur = [0] * cols
    prev = [0] * cols
        
    for i in range(1, rows):
        cur, prev = prev, cur
        for j in range(1, cols):
            if s1[i - 1] == s2[j - 1]:
                cur[j] = 1 + prev[j - 1]
            else:
                cur[j] = max(prev[j], cur[j - 1])
        
    return cur[-1]

s1 = input()
s2 = input()

start = time.perf_counter_ns()
ans = recur_lcs(s1, s2)
end = time.perf_counter_ns()
print(ans, end-start)