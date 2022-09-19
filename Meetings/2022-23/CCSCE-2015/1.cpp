#include <bits/stdc++.h>
using namespace std;

#define nl '\n'

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int n, s, D = 0, B = 0;
  string v;

  for (cin >> s; s > 0; s--) {
    cin >> v;
    if (isdigit(v[0])) {
      n = stoi(v);
      D += n;
      for (; n > 0; n--) cin >> v;
    }
    else while (v != "0") {
      B += 1;
      cin >> v;
    }
  }

  printf("Doris: %d\n", D);
  printf("Boris: %d\n", B);
}
