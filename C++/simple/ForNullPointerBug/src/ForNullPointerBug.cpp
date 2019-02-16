///
/// Author: MaAb
///

namespace faulty {

struct A {
   int num;
};

int mayFailOrNot(int argc) {
    A *a = nullptr;
    for (int i = 1; i < argc; i++) {
        return 0;
    }
    return a->num;
}
}

///
/// Entry point of program
///
int main(int argc, char** argv) {
  return faulty::mayFailOrNot(argc);
}
