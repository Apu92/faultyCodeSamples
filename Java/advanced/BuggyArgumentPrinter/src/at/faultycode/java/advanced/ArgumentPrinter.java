package at.faultycode.java.advanced;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class ArgumentPrinter {

  /** Default Java logger **/
  private static final Logger LOGGER = Logger.getLogger(ArgumentPrinter.class.getName());

  private Object[] ARGS;
  private Integer maxArgs;

  
  public void setArguments(final Object[] args, Integer maxArgs) {
    this.ARGS = new String[maxArgs]; this.maxArgs = maxArgs;
    synchronized (maxArgs) { initArgs(args, maxArgs); }
  }
  
  private void initArgs(final Object[] args, final Integer maxNumArgs) {
    synchronized (ARGS) { for (int i = 0; i < maxNumArgs; i++) { ARGS[i] = args[i]; } }
  }

  /**
   * Logs the number of arguments and the content of each argument.
   */
  public void logAll() {
    synchronized (ARGS) { logNumberOfArguments(); logAllArguments(); }
  }

  private void logNumberOfArguments() {
    String formatString = createFormatStringNumArgs();
    if (!formatString.isEmpty()) 
      LOGGER.info(String.format(formatString, ARGS.length)); 
  }

  private void logArgumentContent(Integer index) {
    LOGGER.info(String.format("Arg[%d]: '%s'", index, ARGS[index].toString()));
  }

  private void logAllArguments() {
    synchronized (maxArgs) { for (int i = 0; i <= maxArgs; i++) { logArgumentContent(i); } }
  }

  private String createFormatStringNumArgs() {
    if (ARGS.length == 1) return "%d argument is entered!"; 
    else if (ARGS.length > 1) return "%d argument(s) are entered!";
    return null;
  }
}
