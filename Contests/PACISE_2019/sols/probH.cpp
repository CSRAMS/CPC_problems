#include <iostream>
#include <vector>
#include <algorithm>

int
countSubsetsRec (int* arr, int i, int sum, std::vector<int>& p, bool** dp)
{
  if (i == 0 && sum != 0 && dp[0][sum])
  {
    p.push_back (arr[i]);
    return 1;
  }
  if (i == 0 && sum == 0)
  {
    return 1;
  }
  int count = 0;
  if (dp[i - 1][sum])
  {
    std::vector<int> b = p;
    count += countSubsetsRec (arr, i - 1, sum, b, dp);
  }
  if (sum >= arr[i] && dp[i - 1][sum - arr[i]])
  {
    p.push_back (arr[i]);
    count += countSubsetsRec (arr, i - 1, sum - arr[i], p, dp);
  }
  return count;
}

int
countAllSubsets (int* arr, int n, int sum, bool** dp)
{
  if (n == 0 || sum < 0) {
    return 0;
  }
  if (arr[0] <= sum) {
    dp[0][arr[0]] = true;
  }
  for (int i = 1; i < n; ++i) {
    for (int j = 0; j < sum + 1; ++j) {
      dp[i][j] =
        (arr[i] <= j) ? dp[i - 1][j] || dp[i - 1][j - arr[i]] : dp[i - 1][j];
    }
  }
  if (!dp[n - 1][sum])
  {
    return 0;
  }
  std::vector<int> p;
  return countSubsetsRec (arr, n - 1, sum, p, dp);
}

// Driver code
int main ()
{
  int N, S;
  while (std::cin >> N >> S, N != 0) {
    std::vector<int> arr (N);
    for (auto & v : arr) {
      std::cin >> v;
    }
    std::sort(arr.begin(), arr.end());
    bool** dp = new bool* [N];
    for (int i = 0; i < N; ++i)
    {
      dp[i] = new bool[S + 1];
      std::fill_n(dp[i], S + 1, false);
      dp[i][0] = true;
    }
    std::cout << countAllSubsets (arr.data(), N, S, dp) << '\n';
    for (int i = 0; i < N; ++i) {
      delete[] dp[i];
    }
    delete[] dp;
  }
  return 0;
}
