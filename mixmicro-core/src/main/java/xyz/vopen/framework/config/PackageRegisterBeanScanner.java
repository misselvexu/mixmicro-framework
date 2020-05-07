package xyz.vopen.framework.config;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.util.Set;

/**
 * Classes under Registered Package Scanning matching TypeFilter classes according to the specified
 * package registers them in IOC Only Scanner {@link RegisterBean} implement class
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @see
 *     BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry)
 */
public class PackageRegisterBeanScanner extends ClassPathBeanDefinitionScanner {
  /** base packages of scanner */
  private String[] basePackages;

  public PackageRegisterBeanScanner(BeanDefinitionRegistry registry) {
    super(registry, false);
    addIncludeFilter(new AssignableTypeFilter(RegisterBean.class));
  }

  /**
   * Execute scanning {@link RegisterBean} implement class to register
   *
   * @return
   * @see
   *     org.springframework.beans.factory.support.BeanDefinitionReaderUtils#registerBeanDefinition(BeanDefinitionHolder,
   *     BeanDefinitionRegistry)
   */
  public Set<BeanDefinitionHolder> doScanRegisterBean() {
    return super.doScan(this.basePackages);
  }

  public void setBasePackages(String[] basePackages) {
    this.basePackages = basePackages;
  }
}
