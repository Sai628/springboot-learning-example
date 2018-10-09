package demo.springboot.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 用户实体类
 */
@Entity
public class User implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;  // 编号
    private String name;  // 姓名
    private Integer age;  // 年龄
    private String birthday;  // 出生时间


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public Integer getAge()
    {
        return age;
    }


    public void setAge(Integer age)
    {
        this.age = age;
    }


    public String getBirthday()
    {
        return birthday;
    }


    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }


    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + "\'" +
                ", age=" + age +
                ", birthday=" + birthday +
                "}";
    }
}
