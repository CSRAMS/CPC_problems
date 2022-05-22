#include <iostream>
#include <algorithm>
#include <cmath>

int main() {
  double cardboardCost;
  double tapeCost;
  int N;
  int totalCost = 0;

  std::cin >> cardboardCost >> tapeCost >> N;
  cardboardCost /= 144; // normalize to square inches
  tapeCost /= 36; // normalize to inches

  while (N --> 0) {
    double dims[3];
    std::cin >> dims[0] >> dims[1] >> dims[2];
    std::sort (dims, dims + 3);
    double cardboard = 2 * (dims[0] * dims[1] + dims[1] * dims[2] + dims[2] * dims[0]) + 2 * dims[0];
    double tape = 2 * (dims[2] + 2) + 4 * (dims[1] + 2);
    totalCost += std::ceil(cardboard * cardboardCost + tape * tapeCost);
  }
  std::cout << totalCost << std::endl;
  return 0;
}
