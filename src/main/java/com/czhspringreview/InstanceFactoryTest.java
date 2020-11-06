package com.czhspringreview;

import com.czhspringreview.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceFactoryTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_instancefactory.xml");
        Car car =(Car) applicationContext.getBean("car");
        System.out.println(car);
    }
}
