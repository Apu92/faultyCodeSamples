///
/// Author: MaAb
///

namespace faulty {

struct A {
   int num;
};

int mayFailOrNot(int argc) {
    A *a = nullptr;
    switch (argc) {
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
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
