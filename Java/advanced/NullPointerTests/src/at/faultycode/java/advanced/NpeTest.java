package at.faultycode.java.advanced;

public class NpeTest {

  private boolean isNull(Object o) {
    return o == null;
  }

  private Object getNull() {
    return null;
  }

  public void test() {
    Object o = null;

    if (isNull(o)) {
      o.hashCode(); // NPE
    }

    if (!isNull(o)) {
      o.hashCode();
    }

    if (o != null) {
      o.hashCode();
    }

    getNull().hashCode(); // NPE

    if (NpeTestHelper.isNull(o)) {
      o.hashCode(); // NPE
    }

    if (!NpeTestHelper.isNull(o)) {
      o.hashCode();
    }

    NpeTestHelper.getNull().hashCode(); // NPE
  }

}
