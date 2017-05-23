package com.mtm_fk;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(name = "teachers_students", joinColumns = {@JoinColumn(name = "sid")},
    inverseJoinColumns = {@JoinColumn(name = "tid")})
    private Set<Teachers> teachers; //学生持有教师的集合



    public Student() {
    }

    public Student(String sname, String gender, Date birthday, String major) {
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.sname = sname;

    }

    public Set<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teachers> teachers) {
        this.teachers = teachers;
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
