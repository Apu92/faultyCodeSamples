///
/// Author: MaAb
///
#include <time.h>
#include <stdlib.h>
#include <stdio.h>

namespace faulty {

///
/// Entry point of program
///
int main(int argc, char** argv) {

	int* random = (int*) malloc(sizeof(int));
	if (random == nullptr) {
		perror("Out of memory");
		return -1;
	}

	srand(time(NULL));
	*random = rand() % 11;  // Random number between 0 - 10

	return *random;
}
}
