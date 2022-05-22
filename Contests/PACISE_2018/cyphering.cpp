using namespace std;
#include <bits/stdc++.h>
#define nl '\n'
#define td typedef struct

void incr(string::iterator &it, string &str) {
    ++it;
    if (it == str.end()) it = str.begin();
}

void solve() {
    string key, msg;
    cin >> key >> msg;

    char c;
    auto k = key.begin();
    for (auto it = msg.begin(); it != msg.end(); ++it, incr(k, key)) {
        c = *it + *k - 'A';
        if (c > 'Z') c = c - 'Z' + 'A' - 1;

        cout << c;
    }

    cout << nl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;

    for (cin >> n; n > 0; n--) {
        solve();
    }
}