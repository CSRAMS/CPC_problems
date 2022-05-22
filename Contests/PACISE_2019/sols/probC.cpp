#include <vector>
#include <iostream>

using T = char;

int main() {
  int count, iters;
  std::string start;
  std::cin >> start >> iters;

  std::vector<T> Old, New;
  count = 0;
  for (char c : start) {
    Old.push_back(c - '0');
    ++count;
  }

  New.reserve(2 * count);

  while (iters --> 0) {
    T p = -1;
    count = 1;
    for (T c : Old) {
      if (p == c) {
        ++count;
        continue;
      }
      if (p != -1) {
        New.push_back(count);
        New.push_back(p);
        count = 1;
      }
      p = c;
    }
    New.push_back(count);
    New.push_back(p);

    std::swap(Old, New);
    New.resize(0);
    New.reserve(2 * Old.size());
  }

  std::cout << Old.size() << std::endl;
  return 0;
}
