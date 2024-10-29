package com.xuexi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionDefaults;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author fntp
 * @since 2024/10/26
 */
public class TestBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(BeanConfiguration.class).setScope("singleton").getBeanDefinition();
        defaultListableBeanFactory.registerBeanDefinition("beanConfiguration", beanDefinition);
        // 注册BeanPostProcessor 添加后处理器 为BeanFactory添加常用的后处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(defaultListableBeanFactory);
        // 取出BeanFactory的后处理器
        defaultListableBeanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(item->{
            item.postProcessBeanFactory(defaultListableBeanFactory);
        });
        // 处理的Bean的后处理器，生命周期各阶段提供扩展功能
        defaultListableBeanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(defaultListableBeanFactory::addBeanPostProcessor);

        String[] beanDefinitionNames = defaultListableBeanFactory.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        // 尝试使用bean1
        Object bean1 = defaultListableBeanFactory.getBean("bean1");
        if (bean1 instanceof Bean1) {
            // 如果是Bean1类型的
            Bean2 bean2 = ((Bean1) bean1).getBean2();
            if (Objects.nonNull(bean2)) {
                bean2.testBean2();
            }
        }
    }

    @Configuration
    static class BeanConfiguration{

        @Bean
        public Bean1 bean1(){
            return new Bean1();
        }

        @Bean
        public Bean2 bean2(){
            return new Bean2();
        }

    }

    static class Bean1 {

        private static final Logger log = LoggerFactory.getLogger(Bean1.class);

        public Bean1 () {
            log.info("Bean1 created");
        }

        @Autowired
        private Bean2 bean2;

        public Bean2 getBean2() {
            return bean2;
        }

    }

    static class Bean2 {
        private static final Logger log = LoggerFactory.getLogger(Bean2.class);

        public Bean2 () {
            log.info("Bean2 created");
        }

        public void testBean2() {
            System.out.println("test bean2 successfully");
        }
    }

}
