package com.soft1721.janyue.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private Integer uId;
    private String title;
    private String content;
    private Date createTime;

}
