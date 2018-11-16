package at.samplecode.main;

/**
 * 
 * @author mab (marcel.ablasser@student.tugraz.at)
 *
 */
public class DemonstrationPMD { // NOPMD by mab on 29.10.18 15:56

  /**
   * Tries to parse an integer from the transferred string.
   * 
   * @param number
   * @return integer value or -1 in case of an error.
   */
  public Integer convertString2Integer(final String number) {
    Integer value = Integer.valueOf(-1); // NOPMD by mab on 29.10.18 15:55

    try {
      value = Integer.parseInt(number);
    } catch(NumberFormatException e) {
    }

    return value;
  }

}
