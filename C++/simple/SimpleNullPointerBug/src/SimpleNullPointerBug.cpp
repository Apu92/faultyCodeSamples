///
/// Author: MaAb
///

namespace faulty {

struct A {
   int num;
};

int failsForSure() {
    A *a = nullptr;
    return a->num;
}
}

///
/// Entry point of program
///
int main() {
  return failsForSure();
}
