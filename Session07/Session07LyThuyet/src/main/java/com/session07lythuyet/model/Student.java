package com.session07lythuyet.model;

/**
 * Model class đại diện cho một sinh viên.
 * Spring sẽ tự động bind các form field vào các property của object này
 * thông qua @ModelAttribute.
 */
public class Student {

    private String name;
    private String email;
    private int age;
    private String major;

    public Student() {
    }

    public Student(String name, String email, int age, String major) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', email='" + email + "', age=" + age + ", major='" + major + "'}";
    }
}
