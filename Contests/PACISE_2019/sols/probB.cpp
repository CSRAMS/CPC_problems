#include <functional>
#include <iostream>
#include <regex>
#include <unordered_map>
#include <utility>

const std::regex ASSIGN_OP{R"((\w+) -> (\w+))", std::regex::optimize};
const std::regex NOT_OP{R"(NOT (\w+) -> (\w+))", std::regex::optimize};
const std::regex BINARY_OP{R"((\w+) (AND|OR|LSHIFT|RSHIFT) (\w+) -> (\w+))",
                           std::regex::optimize};

using Int = uint16_t;
using Callback = Int(*)(Int, Int);

Int Assign(Int a, Int) { return a; }

Int Not(Int a, Int) { return ~a; }

Int And(Int a, Int b) { return a & b; }

Int Or(Int a, Int b) { return a | b; }

Int LShift(Int a, Int b) { return a << b; }

Int RShift(Int a, Int b) { return a >> b; }

struct Gate {
  Callback fn;
  std::string wire1, wire2;
  bool memoized{false};
  Int value;
  Gate(std::string w1, std::string w2, Callback f)
      : fn{f}, wire1{w1}, wire2{w2} {}

  Gate(std::string w1, Callback f) : Gate(w1, w1, f){};

  Gate(Int v) : memoized{true}, value{v} {};
};

struct Circuit {
  std::unordered_map<std::string, Gate> lookup;

  void set(std::string key, Int v) { lookup.at(key) = Gate{v}; }

  Int get(std::string value) {
    try {
      return std::stoi(value);
    } catch (...) {
      auto &d = lookup.at(value);
      if (d.memoized) {
        return d.value;
      }
      d.memoized = true;
      return (d.value = d.fn(get(d.wire1), get(d.wire2)));
    }
  }

  void add(std::string line) {
    std::smatch m;
    if (std::regex_match(line, m, ASSIGN_OP)) {
      lookup.emplace(m.str(2), Gate{m.str(1), Assign});
    } else if (std::regex_match(line, m, NOT_OP)) {
      lookup.emplace(m.str(2), Gate{m.str(1), Not});
    } else if (std::regex_match(line, m, BINARY_OP)) {
      if (m.str(2) == "AND") {
        lookup.emplace(m.str(4), Gate{m.str(1), m.str(3), And});
      } else if (m.str(2) == "OR") {
        lookup.emplace(m.str(4), Gate{m.str(1), m.str(3), Or});
      } else if (m.str(2) == "LSHIFT") {
        lookup.emplace(m.str(4), Gate{m.str(1), m.str(3), LShift});
      } else if (m.str(2) == "RSHIFT") {
        lookup.emplace(m.str(4), Gate{m.str(1), m.str(3), RShift});
      }
    }
  }
};

int main() {
  std::string line;
  int gates;

  std::string target;
  std::cin >> target >> gates;
  std::getline(std::cin, line);

  Circuit c;

  while (gates-- > 0) {
    std::getline(std::cin, line);
    c.add(line);
  }
  std::cout << c.get(target) << std::endl;
  return 0;
}
