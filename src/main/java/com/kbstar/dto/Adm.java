package com.kbstar.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Adm {
    private int id;
    private String adminId;
    private String pwd;
    private int lev;
}
