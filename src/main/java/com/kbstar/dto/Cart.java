package com.kbstar.dto;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
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
