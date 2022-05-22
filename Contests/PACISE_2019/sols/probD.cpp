#include <iostream>
#include <limits>
#include <set>
#include <unordered_map>
#include <vector>

int lookup_id (const std::string & name) {
  static int shist = 0;
  static std::unordered_map <std::string, int> lookup;
  auto loc = lookup.find (name);
  if (loc != std::end (lookup))
    return loc->second;
  return (lookup [name] = 1 << shist++);
}

int main() {
  int N;
  std::cin >> N;

  std::unordered_map <int, int> dist;
  std::set <int> p;

  for (int i = 0; i < N * (N - 1); ++i) {
    std::string n1, n2;
    int val;
    std::cin >> n1 >> val >> n2;
    int h1 = lookup_id (n1);
    int h2 = lookup_id (n2);
    p.insert (h1);
    p.insert (h2);
    dist [h1 ^ h2] += val;
  }

  std::vector <int> order { std::cbegin (p), std::cend (p) };
  int d { std::numeric_limits <int>::min() };
  do {
    int curr { dist [order.front() | order.back()] };
    for (auto && p = std::cbegin (order) + 1; p != std::cend (order); ++p)
      curr += dist [*p | *(p - 1)];
    d = std::max (d, curr);
  } while (std::next_permutation (std::begin (order), std::end (order)));
  std::cout << d << std::endl;
}
