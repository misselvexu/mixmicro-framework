package xyz.vopen.framework.util;

/**
 * String Utils string {@link String} manipulation tool class
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 */
public class StringUtils {
  /**
   * First letter lowercase {@link Character#toLowerCase(char)}
   *
   * @param s Original string
   * @return Converted string
   */
  public static String toLowerCaseFirstOne(String s) {
    if (Character.isLowerCase(s.charAt(0))) {
      return s;
    } else {
      return (new StringBuilder())
          .append(Character.toLowerCase(s.charAt(0)))
          .append(s.substring(1))
          .toString();
    }
  }

  /**
   * First letter capitalized {@link Character#toUpperCase(char)}
   *
   * @param s Original string
   * @return Converted string
   */
  public static String toUpperCaseFirstOne(String s) {
    if (Character.isUpperCase(s.charAt(0))) return s;
    else
      return (new StringBuilder())
          .append(Character.toUpperCase(s.charAt(0)))
          .append(s.substring(1))
          .toString();
  }
}
