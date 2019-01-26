///
/// Author: MaAb
///
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <iostream>

namespace faulty {

int mayFailOrNot() {
	int* random = (int*) malloc(sizeof(int));
	if (random == nullptr) {
		perror("Out of memory");
		return -1;
	}

	srand(time(NULL));
	*random = rand() % 11;  // Random number between 0 - 10

	std::cout << "Your random number is: " << *random << "\n";
	free(random);
	free(random);

	return 0;
}
}

///
/// Entry point of program
///
int main(int argc, char** argv) {
  return faulty::mayFailOrNot();
}
