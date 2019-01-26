///
/// Author: MaAb
///
#include <iostream>

namespace faulty {

void failsForSure() {
	std::cout << argc << " arguments are entered.\n";

	for (int i = 0; i <= argc; ++i) {
		std::cout << i << ": " << argv[i] << "\n";
	}
}
}

///
/// Entry point of program
///
int main(int argc, char** argv) {
  faulty::failsForSure();
  return 0;
}
