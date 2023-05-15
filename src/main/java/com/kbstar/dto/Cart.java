package com.kbstar.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cart {
    private int id;
    private int userId;
    private int itemId;
    private int cnt;
    private LocalDateTime rdate;
}
