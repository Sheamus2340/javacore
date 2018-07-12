package org.sheamus.java.annotation;

/**
 * Created by Sheamus on 2018/7/12.
 */
@Table("student")
public class Student {
    @Field(columName = "id",type = "int",length = 12)
    private int id;
    @Field(columName = "name",type = "varchar",length = 20)
    private String studentName;
    @Field(columName = "age",type = "int",length = 1)
    private int age;

    public Student() {
    }

    public Student(int id, String studentName, int age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
