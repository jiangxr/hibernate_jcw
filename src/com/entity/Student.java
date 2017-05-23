package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangchangwei on 2017/5/23.
 * 学生实体类
 */
@Entity
@Table(name="t_student", schema="hibernate")
public class Student implements Serializable {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sid;
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(generator = "sid")
    @GenericGenerator(name = "sid", strategy = "assigned")
    private String sname;
    private String gender;
    private Date birthday;
    private String major;
//    private String address;
    @Transient
    private double salary;
    @Embedded
    private Address add;


    public Student() {
    }

    public Student(int sid, String sname, String gender, Date birthday, String major, Address add) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.add = add;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }
}
