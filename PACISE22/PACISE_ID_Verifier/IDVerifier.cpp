using namespace std;
#include <bits/stdc++.h>
#define nl '\n'
#define td typedef struct

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string id;
    int sum = 0, d;
    bool dbl = 0;
    cin >> id;

    for (auto it = id.rbegin(); it != id.rend(); ++it) {
        if (dbl && *it >= '5') {
            d = (*it - '0') * 2;
            sum += (d % 10) + (d / 10);
        } else if (dbl) sum += (*it - '0') * 2;
        else sum += *it - '0';

        dbl = !dbl;
    }

    if (!(sum % 10)) cout << "VALID" << nl;
    else cout << "INVALID" << nl;
}