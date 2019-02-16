///
/// Author: MaAb
///

#include <iostream>
#include <stdio.h>

namespace faulty {

int mayFailOrNot(int argc) {
	try {
		FILE* f = fopen("output.txt", "w");
		if (f != NULL) {
			int result = fputs("HelloWorld!", f);
			if (result != EOF) {
				throw 1;
			}

			fclose(f);
		}
	} catch (...) {
		std::cout << "Exception occurred!\n";
		return 1;
	}
	return 0;
}
}

///
/// Entry point of program
///
int main(int argc, char** argv) {
  return faulty::mayFailOrNot(argc);
}
