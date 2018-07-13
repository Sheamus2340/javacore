package org.sheamus.java.enumerate;

/**
 * Created by Sheamus on 2018/7/13.
 */
public enum Seasons {
    Spring("春"),Sunmmer("夏"),Fall("秋"),Winter("冬");
    private String name;
    Seasons(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Test {
    public static void main(String[] args) {
        String name = Seasons.Spring.getName();
        System.out.println(name);
    }
}
