package com.xuexi;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author fntp
 * @since 2024/10/25
 */
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) throws Exception{
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApp.class, args);
//        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
//        singletonObjects.setAccessible(Boolean.TRUE);
//        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
////        Object objectsMap = singletonObjects.get(beanFactory);
//        Map<String, Object> stringObjectMap = (Map<String, Object>) singletonObjects.get(beanFactory);
//        System.out.println(stringObjectMap);
////        System.out.println(objectsMap);
//        stringObjectMap.entrySet().stream().filter(target-> target.getKey().startsWith("component")).forEach(item->{
//            System.out.println(item.getKey()+":"+ JSON.toJSONString(item.getValue()));
//        });
//        // 默认实现
////        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        try {
            SpringApplication.run(MainApp.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
