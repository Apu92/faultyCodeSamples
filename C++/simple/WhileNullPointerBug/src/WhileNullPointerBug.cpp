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
    A *a = A();
    *a->num = argc;
    
    int i = 0;
    while (i < argc) {
      *a = nullptr;
    }
    
    return a->num;
}
