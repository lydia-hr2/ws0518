package com.kbstar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Cart {
    private int id;
    private int userId;
    private int itemId;
    private int cnt;
    private LocalDateTime rdate;

    public Cart(int userId, int itemId, int cnt) {
        this.userId = userId;
        this.itemId = itemId;
        this.cnt = cnt;
    }
}
