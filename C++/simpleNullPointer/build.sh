#!/bin/sh

#cd src

make clean

#make

export SM_DISABLE_ANALYSIS=true
./configure
unset SM_DISABLE_ANALYSIS

#make
make
