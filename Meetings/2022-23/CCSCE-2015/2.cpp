#include <bits/stdc++.h>
using namespace std;

#define nl '\n'

ostream& operator<< (ostream &os, const vector<int> v) {
  for (auto it = v.rbegin(); it != v.rend(); ++it) {
    os << *it;
  }

  return os;
}

void carry (vector<int> &read, const int b) {
  bool c = 0;
  for (int &dig : read) {
    if (c) dig++;

    if (dig < b) break;

    c = 1;
    dig = 0;
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int b, n, r, incr;
  vector<int> read;

  while (true) {
    cin >> b;
    if (b == -1) break;

    cin >> n >> r >> incr;
    read.clear();

    for (int i = 0; i < n; i++) { // Fill `read` vector with digits of `r`
      read.push_back((r / (int)pow(10, i)) % 10);
    }

    for (; incr > 0; incr--) {
      read[0]++;
      if (read[0] >= b) carry(read, b);

      cout << read << nl;
    }
  }
}
