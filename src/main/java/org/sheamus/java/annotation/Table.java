package org.sheamus.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ORM 框架的自定义注解
 * Created by Sheamus on 2018/7/12.
 */
@Target({ElementType.TYPE}) // 表示作用在类、接口、枚举上
@Retention(RetentionPolicy.RUNTIME) // 表示运行时也存在，可以使用反射获取到这个注解
public @interface Table {
    String value();
}
