///
/// Author: MaAb
///
#include <iostream>

namespace faulty {

void failsForSure() {
	std::cout << argc << " arguments are entered.\n";

	std::cout << argv[argc] << "\n";
}
}

///
/// Entry point of program
///
int main(int argc, char** argv) {
  faulty::failsForSure();
  return 0;
}
