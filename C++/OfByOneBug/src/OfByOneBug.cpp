
#include <iostream>

int main(int argc, char** argv) {

	std::cout << argc << " arguments are entered.\n";

	for (int i = 0; i <= argc; ++i) {
		std::cout << i << ": " << argv[i] << "\n";
	}
}
