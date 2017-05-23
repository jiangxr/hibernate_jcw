package com.oto_bfk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by jiangchangwei on 2017/5/23.
 * 身份证类
 */
@Entity
public class IdCard {
    @Id
    @GeneratedValue(generator = "pid")
    @GenericGenerator(name="pid", strategy = "assigned")
    @Column(length = 18)
    private String pid;
    private String sname;
    @OneToOne(mappedBy = "card")
    private Student student;

    public IdCard() {
    }

    public IdCard(String pid, String sname) {
        this.pid = pid;
        this.sname = sname;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
