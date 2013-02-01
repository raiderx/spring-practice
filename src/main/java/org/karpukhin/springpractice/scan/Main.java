package org.karpukhin.springpractice.scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

/**
 * @author Pavel Karpukhin
 * @since 01.02.13
 */
public class Main {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.karpukhin.springpractice.scan.bean");
        Service service = context.getBean(Service.class);
        service.someMethod();
    }

    public static void test2() {
        GenericApplicationContext context = new GenericApplicationContext();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context, false);
        scanner.addIncludeFilter(new AbstractClassTestingTypeFilter() {
            @Override
            protected boolean match(ClassMetadata metadata) {
                return metadata.isConcrete();
            }
        });
        scanner.scan("org.karpukhin.springpractice.scan.bean");
        Service service = context.getBean(Service.class);
        service.someMethod();
    }
}
