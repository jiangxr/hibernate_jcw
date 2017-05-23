package po;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jiangchangwei on 2017/5/22.
 */
public class Students {
    //公有的类
    //提供公有的不带参数的默认的构造方法
    //属性私有
    //提供setter和getter方法
    private int sid;
    private String sname;
    private String gender;
    private Date birthday;
//    private String address;
//    private Blob pictures;
    private Address address;

    public Students() {
    }

    public Students(int sid, String sname, String gender, Date birthday, String address) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
//        this.address = address;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (sid != students.sid) return false;
        if (sname != null ? !sname.equals(students.sname) : students.sname != null) return false;
        if (gender != null ? !gender.equals(students.gender) : students.gender != null) return false;
        if (birthday != null ? !birthday.equals(students.birthday) : students.birthday != null) return false;
        if (address != null ? !address.equals(students.address) : students.address != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
