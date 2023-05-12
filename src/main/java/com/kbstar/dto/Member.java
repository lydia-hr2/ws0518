package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Member {
    private int member_id;
    private String email;
    private String password;
    private String name;
    private String tel;
    private String birth;
    private Date rdate;
    private int valid;
}
