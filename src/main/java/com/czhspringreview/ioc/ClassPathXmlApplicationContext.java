package com.czhspringreview.ioc;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    Map<String,Object> ioc = new HashMap<String, Object>();
    public ClassPathXmlApplicationContext(String path){
        try {
            //xml解析器
            SAXReader reader = new SAXReader();

            //找到xml路径
            Document document = reader.read("./src/main/resources/"+path);

            //System.out.println("xml路径："+document);  //xml路径：org.dom4j.tree.DefaultDocument@270421f5 [Document: name ./src/main/resources/springioc.xml]
            //找到beans文件
            Element root = document.getRootElement();

            //System.out.println(root);
            //再通过迭代找到beans文件中的单个bean文件
            Iterator<Element> beans = root.elementIterator();
            while (beans.hasNext()){
                //再在单个bean文件中获取id和class属性
                Element bean = beans.next();
                String id = bean.attributeValue("id");
                String className = bean.attributeValue("class");

                //打印id和className
                //System.out.println(id);
                //System.out.println(className);
                //然后通过反射机制创建对象
                Class cls = Class.forName(className);

                //获取无参构造函数，创建目标对象
                Constructor constructor = cls.getConstructor();
                Object object = constructor.newInstance();

                //然后给目标对象赋值,先取出properties
                Iterator<Element> properties = bean.elementIterator();
                while (properties.hasNext()){
                    //再取出properties中的property
                    Element property = properties.next();

                    //取出property中的name和value
                    String name = property.attributeValue("name");
                    String valueStr = property.attributeValue("value");
                    String ref = property.attributeValue("ref");

                    //判断ref是否为null,为null说明是一般赋值，不为null说明是引用赋值
                    if (ref == null){
                        //构建setName等方法，仔细观察是由"set"+首字母大写加后面的单词构成方法
                        String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);

                        //打印验证是否是set方法,setId,setAge,setName
                        //System.out.println(methodName);
                        //然后获取参数类型，name对应的filed
                        Field field = cls.getDeclaredField(name);

                        //然后获取方法，传入两个参数，一个是参数方法名，一个是参数类型
                        Method method = cls.getDeclaredMethod(methodName,field.getType());

                        //打印验证是否获取到对应方法,验证生效
                        //System.out.println(method);
                        //通过反射给对象赋值，传两个参数，一个是赋值对象object,一个是赋值内容value
                        //注意此处value的类型多样，需要先进行类型转换
                        Object value = null;
                        if (field.getType().getName() == "long"){
                            value = Long.parseLong(valueStr);
                        }
                        if (field.getType().getName() == "int"){
                            value = Integer.parseInt(valueStr);
                        }
                        if (field.getType().getName() == "java.lang.String"){
                            value = valueStr;
                        }
                        //通过反射给对象赋值
                        method.invoke(object,value);
                    }
                    //然后将id和目标对象放入容器
                    ioc.put(id,object);
                }
            }
            //不为null就为引用赋值，需要进行依赖注入
            Object obj1 = ioc.get("student");
            Object obj2 = ioc.get("address");
           //复杂写不了

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
    }
    //getBean方法
    public Object getBean(String id) {
        //然后在getBean()方法中直接获取id就能得到ioc容器中已经通过反射机制创建好的对象
        return ioc.get(id);
    }
}
