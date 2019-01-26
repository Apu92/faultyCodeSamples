///
/// Author: MaAb
///
#include <vector>

namespace faulty {

int failsForSure() {
  const std::vector<int> vec;
  return vec[0];
}
}

///
/// Entry point of program
///
int main() {
  return faulty::failsForSure();
}