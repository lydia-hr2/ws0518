package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private int id;
    private String name;
    private String img;
    private String content;
    private int price;
    private String itemSize;
    private String color;
    private int isValid;
    private Date rdate;
    private Date udate;

    //mybatis
    private int cnt;
}
