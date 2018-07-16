package org.sheamus.java.annotation.demo;

import java.lang.reflect.Field;

/**
 * Created by Sheamus on 2018/7/16.
 */
public class Apple {
    @FruitName(value = "苹果",alias = "富士苹果")
    private String name;
    @FruitColor(fruitColor = Color.RED)
    private String color;

    public static void main(String[] args) {
        Field[] declaredFields = Apple.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if(declaredField.isAnnotationPresent(FruitName.class)) {
                FruitName annotation = declaredField.getAnnotation(FruitName.class);
                String value = annotation.value();
                String alias = annotation.alias();
                System.out.println(value + "----" + alias);
            } else if(declaredField.isAnnotationPresent(FruitColor.class)) {
                FruitColor annotation = declaredField.getAnnotation(FruitColor.class);
                Color color = annotation.fruitColor();
                System.out.println(color.name);
            }
        }
    }
}
