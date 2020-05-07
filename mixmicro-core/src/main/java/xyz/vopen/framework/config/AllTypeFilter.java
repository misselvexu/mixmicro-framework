package xyz.vopen.framework.config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.List;

/**
 * Helper class to create a {@link TypeFilter} that matches if all the delegates match.
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @see
 *     org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider#addIncludeFilter(TypeFilter)
 * @see
 *     org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider#addExcludeFilter(TypeFilter)
 * @see org.springframework.core.type.filter.TypeFilter
 * @since 1.0.1
 */
public class AllTypeFilter {
  private final List<TypeFilter> delegates;

  /**
   * Creates a new {@link AllTypeFilter} to match if all the given delegates match.
   *
   * @param delegates must not be {@literal null}.
   */
  public AllTypeFilter(List<TypeFilter> delegates) {

    Assert.notNull(delegates, "TypeFilter deleages must not be null!");
    this.delegates = delegates;
  }

  /*
   * (non-Javadoc)
   * @see org.springframework.core.type.filter.TypeFilter#match(org.springframework.core.type.classreading.MetadataReader, org.springframework.core.type.classreading.MetadataReaderFactory)
   */
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
      throws IOException {

    for (TypeFilter filter : delegates) {
      if (!filter.match(metadataReader, metadataReaderFactory)) {
        return false;
      }
    }

    return true;
  }
}
