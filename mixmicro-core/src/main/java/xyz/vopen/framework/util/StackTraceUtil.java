package xyz.vopen.framework.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Exception StackTrace Util
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 *     <p>
 */
public class StackTraceUtil {
  /**
   * Get Exception Stack Trace
   *
   * @param throwable Exception Instance
   * @return Stack Trace
   */
  public static String getStackTrace(Throwable throwable) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    try {
      throwable.printStackTrace(pw);
      return sw.toString();
    } finally {
      pw.close();
    }
  }
}
