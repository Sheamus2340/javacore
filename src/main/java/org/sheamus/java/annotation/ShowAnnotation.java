package org.sheamus.java.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by Sheamus on 2018/7/12.
 */
public class ShowAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("org.sheamus.java.annotation.Student");

        //获得该类的所有注解
        Annotation[] annotation = aClass.getAnnotations();

        for (Annotation a : annotation ) {
            System.out.println(a);
        }

        // 获取类指定的注解
        Table annotation1 = aClass.getAnnotation(Table.class);
        String value = annotation1.value();
        System.out.println(value);

        // 获取所有声明的属性
        java.lang.reflect.Field[] declaredFields = aClass.getDeclaredFields();
        for(java.lang.reflect.Field filed : declaredFields) {
            if(filed.getAnnotation(Field.class) != null) {
                Field annotation2 = filed.getAnnotation(Field.class);
                String s = annotation2.columName();
                int length = annotation2.length();
                String type = annotation2.type();
                String name = filed.getName();
                System.out.println("属性名称：" + name + "，注解类型名：" + s + ",长度" + length + ",类型" + type);
            }
        }


    }
}
