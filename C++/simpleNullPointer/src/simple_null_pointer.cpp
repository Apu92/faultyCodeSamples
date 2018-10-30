#include <vector>

#include "../include/simple_null_pointer.h"

struct A {
   int num;
};

int simpleNullPointer()
{
    A *a = nullptr;
    return a->num;
}

int noSimpleNullPointer()
{
    return 5;
}
