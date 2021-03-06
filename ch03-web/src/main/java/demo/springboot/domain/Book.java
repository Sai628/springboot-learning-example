package demo.springboot.domain;

import java.io.Serializable;


public class Book implements Serializable
{
    private Long id;  // 编号
    private String name;  // 书名
    private String writer;  // 作者
    private String introduction;  // 简介


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


    public String getWriter()
    {
        return writer;
    }


    public void setWriter(String writer)
    {
        this.writer = writer;
    }


    public String getIntroduction()
    {
        return introduction;
    }


    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }
}
