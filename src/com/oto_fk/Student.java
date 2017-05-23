package com.oto_fk;

import com.entity.Address;
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
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sid;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid", unique = true)
    private IdCard card;
    private String gender;
    private Date birthday;
    private String major;



    public Student() {
    }

    public Student(IdCard card, String gender, Date birthday, String major) {
        this.card = card;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;

    }

    public IdCard getCard() {
        return card;
    }

    public void setCard(IdCard card) {
        this.card = card;
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
