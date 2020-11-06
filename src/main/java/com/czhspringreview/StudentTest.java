package com.czhspringreview;

import com.czhspringreview.entity.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

public class StudentTest {
    public static void main(String[] args) {
        //传统new对象方式
//        Student student = new Student();
//        student.setId(1L);
//        student.setAge(18);
//        student.setName("阿华");
//        System.out.println(student);   Student(id=1, age=18, name=阿华)

        //采用IOC控制反转
        //先指明配置文件路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springioc.xml");
        //再来通过IOC容器创建对象,注意类型强转
       // Student student = (Student) applicationContext.getBean("student");
       // System.out.println(student);  //Student(id=2, age=20, name=大猫)
        //spring继承测试
        Student stu = (Student) applicationContext.getBean("stu");
        System.out.println(stu);
    }
}
