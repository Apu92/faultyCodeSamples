cmake_minimum_required(VERSION 2.8.12)

project(SimpleNullPointer)

set(CMAKE_INCLUDE_CURRENT_DIR ON)
set(CMAKE_AUTOMOC ON)

find_package(Qt5Core)
find_package(Qt5Test)

add_executable(${PROJECT_NAME} "src/main.cpp" "include/simple_null_pointer.h" "src/simple_null_pointer.cpp")

target_link_libraries(${PROJECT_NAME} Qt5::Core)


include(CTest)

add_executable(basic_qttest "test/basic_qttest.cpp" "include/simple_null_pointer.h" "src/simple_null_pointer.cpp")
target_link_libraries(basic_qttest Qt5::Test)
add_test(basic_qttest basic_qttest)
