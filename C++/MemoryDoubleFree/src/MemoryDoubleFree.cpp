
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <iostream>

int main(int argc, char** argv) {

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
