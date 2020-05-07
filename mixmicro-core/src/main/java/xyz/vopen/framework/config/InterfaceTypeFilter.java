package xyz.vopen.framework.config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Type Filter{@link org.springframework.core.type.filter.TypeFilter} Of Interface Filtering
 * conditions for scanning classes by type
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @see
 *     org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider#addIncludeFilter(TypeFilter)
 * @see
 *     org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider#addExcludeFilter(TypeFilter)
 * @see org.springframework.core.type.filter.TypeFilter
 * @since 1.0.1
 */
public class InterfaceTypeFilter extends AssignableTypeFilter {

  public InterfaceTypeFilter(Class<?> targetType) {
    super(targetType);
  }

  /*
   * (non-Javadoc)
   * @see org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter#match(org.springframework.core.type.classreading.MetadataReader, org.springframework.core.type.classreading.MetadataReaderFactory)
   */
  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
      throws IOException {

    return metadataReader.getClassMetadata().isInterface()
        && super.match(metadataReader, metadataReaderFactory);
  }
}
