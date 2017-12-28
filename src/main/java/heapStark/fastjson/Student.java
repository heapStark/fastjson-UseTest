package heapStark.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by wangzhilei3 on 2017/12/28.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String name;
    private int age;
    private Date birthday;
    private Gender gender;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBrithday() {
        return birthday;
    }

    public void setBirthday(Date brithday) {
        this.birthday = brithday;
    }

    @JSONField(serialize = true)
    public Gender getGender() {
        return gender;
    }
    /*@JSONField(serialize = true,name = "genderCode")
    public int getGenderCode() {
        return gender.getCode();
    }
    @JSONField(serialize = true,name = "genderMessage")
    public String getMessage() {
        return gender.getMessage();
    }*/
    @JSONField(deserialize = true)
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    /*@JSONField(deserialize = true)
    public void setGenderCode(int gender) {
        this.gender = CodeEnumUtil.codeOf(Gender.class,gender);
    }*/

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }
    public Student(String name, int age, Date birthday, Gender gender) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Student() {
    }
}
