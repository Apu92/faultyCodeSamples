///
/// Author: MaAb
///

namespace faulty {

struct A {
   int num;
};

int mayFailOrNot(int argc) {
    A *a = nullptr;
    if (argc == 2) {
      return a->num;
    }
    return argc;
}
}

///
/// Entry point of program
///
int main(int argc, char** argv) {
  return faulty::mayFailOrNot(argc);
}
