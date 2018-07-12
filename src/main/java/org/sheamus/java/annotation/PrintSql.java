package org.sheamus.java.annotation;

import java.lang.reflect.*;

/**
 * 拼接SQL并打印
 * Created by Sheamus on 2018/7/12.
 */
public class PrintSql {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Student student1 = new Student(1,"张三,hu",23);
        Student student2 = new Student(2,"李四",22);
        Student student3 = new Student(3,"王五",25);

        String sql1 = assembleSqlFromObj(student1);
        String sql2 = assembleSqlFromObj(student2);
        String sql3 = assembleSqlFromObj(student3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

    }

    /**
     * 给定的对象输出对应的SQL
     * @param object
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static String assembleSqlFromObj(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> studentClass = object.getClass();
        Table table = studentClass.getAnnotation(Table.class);
        String tableName = table.value();// 表的名称
        // 获取类中声明的字段
        java.lang.reflect.Field[] studentClassDeclaredFields = studentClass.getDeclaredFields();

        StringBuilder sbSql = new StringBuilder("select * from " + tableName + " where 1= 1 ");

        for(java.lang.reflect.Field field : studentClassDeclaredFields) {
            // 这里通过截取字符串得到get方法
            String fieldName = field.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);

            Field fieldAnnotation = field.getAnnotation(Field.class);
            if(fieldAnnotation != null) {
                String columName = fieldAnnotation.columName();
                String type = fieldAnnotation.type();

                // 通过方法名得到对应的方法对象
                Method method = studentClass.getMethod(methodName);

                String value = "";
                if("varchar".equals(type)) {
                    value = (String)method.invoke(object);// 反射出get方法返回的数据
                } else {
                    value = (int)method.invoke(object) + "";// 反射出get方法返回的数据
                }


                if (value != null && !value.equals("")) {
                    if (!isNum(columName) && !isNum(value)) {
                        // 判断参数是不是 in 类型参数 1,2,3
                        if (value.contains(",")) {
                            sbSql.append(" and " + columName + " in (" + value + ") ");
                        } else {
                            sbSql.append(" and " + columName + " like '%" + value + "%' ");
                        }
                    } else {
                        sbSql.append(" and " + columName + "=" + value + " ");
                    }
                }
            }
        }

        return sbSql.toString();
    }

    /**
     * 检查给定的值是不是 id 类型 1.检查字段名称 2.检查字段值
     *
     * @param target
     * @return
     */
    public static boolean isNum(String target) {
        boolean isNum = false;
        if (target.toLowerCase().contains("id")) {
            isNum = true;
        }
        if (target.matches("\\d+")) {
            isNum = true;
        }
        return isNum;
    }
}
