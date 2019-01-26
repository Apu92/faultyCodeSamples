///
/// Author: MaAb
///

struct A {
   int num;
};

///
/// Entry point of program
///
int main(int argc, char** argv) {
    A *a = nullptr;
    if (argc == 2) {
      return a->num;
    }
    return argc;
}
