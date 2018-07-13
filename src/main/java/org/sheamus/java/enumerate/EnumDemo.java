package org.sheamus.java.enumerate;

/**
 * https://blog.csdn.net/javazejian/article/details/71333103
 * Created by Sheamus on 2018/7/12.
 */
public class EnumDemo {
    public static void main(String[] args) {
        // 基本方法的测试
//        test1();
//        test2();
//        test3();

    }

    private static void test3() {
        Day[] enumConstants = Day.class.getEnumConstants();
        for(Day day : enumConstants) {
            System.out.println(day);
        }

        boolean anEnum = Day.class.isEnum();
        System.out.println(anEnum);
    }

    private static void test2() {
        // 创建枚举数组
        Day[] days = new Day[]{
                Day.MONDAY, Day.TUESDAY, Day.WEDESDAY,
                Day.THURSDAY, Day.FRIDAY, Day.SATURDAY,
                Day.SUNDAY};

        for (int i = 0; i < days.length; i++) {
            System.out.println("Day " + i + " 's ordinal is " + days[i].ordinal());
        }
        // 编译器自动生成的代码
        Day[] values = Day.values();
        for(Day day : values) {
            System.out.println(day);
        }
    }

    private static void test1() {
        // 直接调用获取对象
        Day monday = Day.MONDAY;
        System.out.println(monday.toString());
        // 通过名称得到Day对象
        Day tuesday = Day.valueOf(Day.TUESDAY.name());
        System.out.println(tuesday);
        // 比较两个枚举对象的大小，默认是比较ordinal的声明序号
        int i = Day.WEDESDAY.compareTo(Day.THURSDAY);
        System.out.println(i);
        // 获取枚举对象的声明对象的序号，从0开始
        System.out.println(Day.FRIDAY.ordinal());
        // 获取枚举对象的声明的Class对象
        Class<Day> declaringClass = Day.SATURDAY.getDeclaringClass();
        System.out.println(declaringClass);
        // 通过枚举的名称和枚举的Class得到该枚举对象,它是一个静态方法
        Day day = Enum.valueOf(Day.class, Day.SUNDAY.name());
        System.out.println(day);
    }

    enum Day {
        MONDAY,TUESDAY,WEDESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
}
