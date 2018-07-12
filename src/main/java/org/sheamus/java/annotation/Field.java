package org.sheamus.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sheamus on 2018/7/12.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD}) // 表示作用在属性上
public @interface Field {
    String columName();
    String type();
    int length();
}
