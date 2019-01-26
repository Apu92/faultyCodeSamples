///
/// Author: MaAb
///
#include <iostream>

namespace faulty {

///
/// Entry point of program
///
int main(int argc, char** argv) {

	std::cout << argc << " arguments are entered.\n";

	std::cout << argv[-1] << "\n";
}
}
