#include <cstdio>
#include <iostream>
#include <unordered_map>

struct state {
  struct action {
    int write;
    char dir;
    char next;
  };
  action act[2];
};

template <typename T, typename Str> T read(std::istream &is, Str &&str) {
  T data;
  std::string line;
  std::getline(std::cin, line);
  std::sscanf(line.c_str(), std::forward<Str>(str), &data);
  return data;
}

int main() {
  auto start = read<char>(std::cin, "Begin in state %c.");
  auto steps = read<int>(std::cin, "Perform a diagnostic checksum after %d steps.");

  std::unordered_map<char, state> states;
  for (std::string line; std::getline(std::cin, line), std::cin;) {
    auto curr = read<char>(std::cin, "In state %c:");
    state s;
    for (int i = 0; i < 2; ++i) {
      auto val = read<int>(std::cin, "  If the current value is %d:");
      s.act[val] =
          state::action{read<int>(std::cin, "    - Write the value %d."),
                        read<char>(std::cin, "    - Move one slot to the %c"),
                        read<char>(std::cin, "    - Continue with state %c.")};
    }
    states.emplace(curr, s);
  }
  std::unordered_map<int, int> tape;
  for (int cursor {0}; steps >= 0; --steps) {
    auto const &curr = states[start].act[tape[cursor]];
    tape[cursor] = curr.write;
    cursor += (curr.dir == 'l') ? -1 : 1;
    start = curr.next;
  }
  int checksum{0};
  for (auto [_, v] : tape)
    checksum += v;
  std::cout << checksum << '\n';
}
