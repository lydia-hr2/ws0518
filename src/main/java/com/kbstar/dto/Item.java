package com.kbstar.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private int id;
    private String registerId;
    private String name;
    private String img;
    private String itemSize;
    private String review;
    private String color;
    private LocalDateTime rdate;
    private LocalDateTime udate;
    private String isValid;

    private MultipartFile imgName;
    private int price;
    private int cnt;

    public Item(String name, String img, String itemSize, String color,int price) {
        this.name = name;
        this.img = img;
        this.itemSize = itemSize;
        this.color = color;
        this.price = price;
    }
}
