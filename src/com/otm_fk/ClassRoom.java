package com.otm_fk;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jiangchangwei on 2017/5/23.
 * 班级实体类
 */
@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name = "cid", strategy="assigned")
    @Column(length = 4)
    private String cid;
    private String cname;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Set<Student> stus;

    public ClassRoom() {
    }

    public ClassRoom(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Set<Student> getStus() {
        return stus;
    }

    public void setStus(Set<Student> stus) {
        this.stus = stus;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
