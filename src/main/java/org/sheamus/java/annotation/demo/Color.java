package org.sheamus.java.annotation.demo;

/**
 * Created by Sheamus on 2018/7/16.
 */
public enum Color {
    BLUE("蓝"),RED("红"),GREEN("绿");
    String name;
    Color(String name) {
       this.name = name;
    }
}
