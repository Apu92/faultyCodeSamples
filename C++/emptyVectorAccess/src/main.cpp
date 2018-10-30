#include <vector>

int foo(){
  const std::vector<int> vec;
  return vec[0]; // Empty vector access reported here
}

int main() {
  foo();
}
