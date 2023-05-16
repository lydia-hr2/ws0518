package com.kbstar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private int memberId;
    private int itemId;
    private int price;
    private LocalDateTime rdate;
    private String name;
    private String zipcode;
    private String addr;
    private String tel;
    private int cnt;
    private String itemName;

    public Order(int memberId, int itemId, int price, LocalDateTime rdate, String name, String zipcode, String addr, String tel, int cnt, String itemName) {
        this.memberId = memberId;
        this.itemId = itemId;
        this.price = price;
        this.rdate = rdate;
        this.name = name;
        this.zipcode = zipcode;
        this.addr = addr;
        this.tel = tel;
        this.cnt = cnt;
        this.itemName = itemName;
    }
}
