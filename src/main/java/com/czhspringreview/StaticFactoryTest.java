package com.czhspringreview;

import com.czhspringreview.entity.Car;
import com.czhspringreview.factory.StaticFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticFactoryTest {
    public static void main(String[] args) {
        //直接调用工厂类方法
        //Car car = StaticFactory.getCar(1L);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_staticfactory.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }
}
