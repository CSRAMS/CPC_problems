#include <bits/stdc++.h>
using namespace std;

#define nl '\n'

bool solve() {
  // Read in data {{{
  int n;

  cin >> n;
  auto logo = vector<vector<bool>>(n, vector<bool>(n, false));

  string s;
  for(auto it = logo.begin(); it != logo.end(); ++it) {
    cin >> s;
    for (int i = 0; i < n; i++)
      if (s[i] == '1') (*it)[i] = true;
  }
  // }}}

  for (int i = 0; i < n / 2; i++) { // We only need to check half the rows, rounded down
    for (int j = 0; j < n; j++) {
      if (logo[i][j] != logo[n-1-i][j]) return false;
    }
  }

  for (int j = 0; j < n / 2; j++) { // We only need to check half the cols, rounded down
    for (int i = 0; i < n; i++) {
      if (logo[i][j] != logo[i][n-1-j]) return false;
    }
  }

  return true;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int t;
  for (cin >> t; t > 0; t--) {
    cout << (solve() ? "YES" : "NO") << nl;
  }
}
