#include <iostream>
#include <string>
int main() {
  std::string s;
  std::getline(std::cin, s);
  std::cout << "Hello " << s << "!" << std::endl;
  return 0;
}
