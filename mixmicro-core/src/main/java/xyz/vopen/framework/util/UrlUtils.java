package xyz.vopen.framework.util;

import org.springframework.util.AntPathMatcher;

import java.util.List;

/**
 * Url utils
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 *     <p>
 */
public class UrlUtils {
  /**
   * check uri is ignore
   *
   * @param ignoreUrls ignore urls
   * @param uri wait check uri
   * @return check result
   */
  public static boolean isIgnore(List<String> ignoreUrls, String uri) {
    // check is matcher ant path
    for (String ignoreUri : ignoreUrls) {
      AntPathMatcher matcher = new AntPathMatcher();
      boolean isMatcher = matcher.match(ignoreUri, uri);
      if (isMatcher) {
        return true;
      }
    }
    return false;
  }
}
