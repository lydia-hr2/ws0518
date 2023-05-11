package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private int item_id;
    private String item_name;
    private String img;
    private String content;
    private int price;
    private Date rdate;
    private Date udate;
}
