package heapStark.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by wangzhilei3 on 2017/12/28.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String name;
    private int age;
    private Date birthday;
    private Gender gender;

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
        this("name",10,new Date(),Gender.FEMALE);
    }
}
