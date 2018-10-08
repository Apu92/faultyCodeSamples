#include <QtTest/QtTest>
#include "../include/simple_null_pointer.h"

class BasicTest : public QObject
{
    Q_OBJECT

private slots:
    void assert_true_test();

    void fail_simple_null_test();

    void pass_no_simple_null_test();
};


void BasicTest::assert_true_test() {
    QVERIFY(true);
}

void BasicTest::fail_simple_null_test() {
    //QVERIFY_EXCEPTION_THROWN(simpleNullPointer(), std::runtime_error);
}

void BasicTest::pass_no_simple_null_test() {
    noSimpleNullPointer();
}

QTEST_MAIN(BasicTest)
#include "basic_qttest.moc"
