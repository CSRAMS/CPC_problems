#include <cctype>
#include <cstdio>
#include <cmath>
#include <utility>
#include <cstdlib>

int main() {
  int x{0}, y{0}, z{0}, dist{0};

  for (char c, v{0}; (c = getchar()) != EOF; ) {
    if (std::isalpha(c)) {
      v ^= c;
      continue;
    }
    switch(std::exchange(v, 0)) {
      case 'n'      :      ++y, --z; break;
      case 'n' ^ 'e': ++x,      --z; break;
      case 's' ^ 'e': ++x, --y     ; break;
      case 's'      :      --y, ++z; break;
      case 's' ^ 'w': --x,      ++z; break;
      case 'n' ^ 'w': --x, ++y     ; break;
    }
  }
  printf("%ld\n", (labs(x) + labs(y) + labs(z)) / 2);
  return 0;
}
