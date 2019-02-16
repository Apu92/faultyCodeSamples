///
/// Author: MaAb
///

namespace faulty {

int mayFailOrNot(int argc) {
	ofstream file;

	try {
		file.open("output.txt");
		file << "HelloWorld!";
		file.close();
	} catch (...) {
		std::cout << "Exception occurred!";
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
