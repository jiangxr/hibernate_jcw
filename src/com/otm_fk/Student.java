package com.otm_fk;

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
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sid;
    private String gender;
    private String sname;
    private Date birthday;
    private String major;



    public Student() {
    }

    public Student(String sname, String gender, Date birthday, String major) {
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.sname = sname;

    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

}
