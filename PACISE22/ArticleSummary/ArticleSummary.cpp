using namespace std;
#include <bits/stdc++.h>
#define nl '\n'
#define td typedef struct

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int w;
    string word;
    map<string, int> dict;

    for (cin >> w; w > 0; w--) {
        cin >> word;

        if (dict[word]) dict[word]++;
        else dict[word] = 1;
    }

    while(!dict.empty()) {
        auto e = max_element(dict.begin(), dict.end(), [](const pair<string,int> &a, const pair<string,int> &b)->bool {
            return a.second < b.second;
        });

        cout << e->first << ' ' << e->second << nl;
        dict.erase(e);
    }
}