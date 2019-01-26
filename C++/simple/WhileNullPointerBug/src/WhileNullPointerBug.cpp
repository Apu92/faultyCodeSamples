///
/// Author: MaAb
///

namespace faulty {

struct A {
   int num;
};

///
/// Entry point of program
///
int main(int argc, char** argv) {
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
