package xyz.vopen.framework.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.lang.reflect.Constructor;

/**
 * Mixmicro Bean Utilities classes
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @since 1.0.1
 */
public class BeanUtils {
  /**
   * Register Infrastructure Bean
   *
   * @param registry {@link BeanDefinitionRegistry}
   * @param beanName the name of bean
   * @param beanClass the class of bean
   * @param constructorArgs the arguments of {@link Constructor}
   */
  public static void registerInfrastructureBean(
      BeanDefinitionRegistry registry,
      String beanName,
      Class<?> beanClass,
      Object... constructorArgs) {
    BeanDefinitionBuilder beanDefinitionBuilder =
        BeanDefinitionBuilder.rootBeanDefinition(beanClass);
    for (Object constructorArg : constructorArgs) {
      beanDefinitionBuilder.addConstructorArgValue(constructorArg);
    }
    // ROLE_INFRASTRUCTURE
    beanDefinitionBuilder.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    // Register
    registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
  }

  /**
   * Register Infrastructure Bean if absent
   *
   * @param registry {@link BeanDefinitionRegistry}
   * @param beanName the name of bean
   * @param beanClass the class of bean
   * @param constructorArgs the arguments of {@link Constructor}
   */
  public static void registerInfrastructureBeanIfAbsent(
      BeanDefinitionRegistry registry,
      String beanName,
      Class<?> beanClass,
      Object... constructorArgs) {
    if (!isBeanDefinitionPresent(registry, beanName, beanClass)
        && !registry.containsBeanDefinition(beanName)) {
      registerInfrastructureBean(registry, beanName, beanClass, constructorArgs);
    }
  }

  /**
   * Is {@link BeanDefinition} present in {@link BeanDefinitionRegistry}
   *
   * @param registry {@link BeanDefinitionRegistry}
   * @param beanName the name of bean
   * @param targetBeanClass the type of bean
   * @return If Present , return <code>true</code>
   */
  public static boolean isBeanDefinitionPresent(
      BeanDefinitionRegistry registry, String beanName, Class<?> targetBeanClass) {
    String[] beanNames = getBeanNames((ListableBeanFactory) registry, targetBeanClass);
    return ArrayUtils.contains(beanNames, beanName);
  }

  /**
   * Get bean names for given "targetBeanClass"
   *
   * @param beanFactory {@link ListableBeanFactory#getBeanNamesForType(Class)}
   * @param targetBeanClass the given target bean class
   * @return target bean class support list names
   */
  public static String[] getBeanNames(ListableBeanFactory beanFactory, Class<?> targetBeanClass) {
    return beanFactory.getBeanNamesForType(targetBeanClass);
  }
}
