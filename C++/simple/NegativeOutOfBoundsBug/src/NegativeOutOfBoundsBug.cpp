///
/// Author: MaAb
///
#include <iostream>

namespace faulty {

void failsForSure(int argc, char** argv) {
	std::cout << argc << " arguments are entered.\n";

	std::cout << argv[-1] << "\n";
}
}

///
/// Entry point of program
///
int main(int argc, char** argv) {
  faulty::failsForSure(argc, argv);
  return 0;
}
