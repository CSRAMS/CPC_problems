#include <bits/stdc++.h>
using namespace std;

#define nl '\n'

ostream& operator<< (ostream &os, const vector<bool> v) {
  os << v[0];
  for (auto it = v.begin()+1; it != v.end(); ++it) {
    os << ' ' << *it;
  }

  return os;
}

bool solve() {
  int n, rows;
  vector<vector<bool>> logo;

  cin >> n;

  logo = vector<vector<bool>>(n, vector<bool>(n, false));
  string s;
  for(auto it = logo.begin(); it != logo.end(); ++it) {
    cin >> s;
    for (int i = 0; i < n; i++) if (s[i] == '1') (*it)[i] = true;
  }

  rows = n / 2;
  vector<bool> r1, r2;
  for (int i = 0; i < rows; i++) {
    r1 = *(logo.begin() + i);
    r2 = *(logo.rbegin() + i);
    for (int j = 0; j < n; j++) {
      if (r1[j] != r2[j]) return false;
    }
  }

  for (int j = 1; j <= rows; j++) {
    for (int i = 0; i < n; i++) {
      if (logo[i][j-1] != logo[i][n-j]) return false;
    }
  }

  return true;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int t;
  for (cin >> t; t > 0; t--) {
    if (solve()) {
      cout << "YES" << nl;
    } else {
      cout << "NO" << nl;
    }
  }
}
