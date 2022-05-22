using namespace std;
#include <bits/stdc++.h>
#define nl '\n'
#define td typedef struct

void solve() {
    int n, p, x, y, v, ans = 0;
    vector<bool> a;
    cin >> n >> p >> x >> y;
    for (; n > 0; n--) {
        cin >> v;
        a.push_back(v);
    }

    for (int i = 0; i < p; i++) {
        if (a[i]) ans += x;
        else ans += y;
    }

    cout << ans << nl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;

    for (cin >> t; t > 0; t--) {
        solve();
    }
}