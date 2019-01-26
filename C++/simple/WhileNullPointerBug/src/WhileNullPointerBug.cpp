///
/// Author: MaAb
///

namespace faulty {

struct A {
   int num;
};

int mayFailOrNot(int argc) {
    A *a = new A();
    a->num = argc;
    
    int i = 2;
    while (i < argc) {
      a = nullptr;
      i++;
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
