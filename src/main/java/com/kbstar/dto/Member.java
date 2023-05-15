package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Member {
    private int member_id;
    @Email
    @NotEmpty
    private String email;
    @Size(min=5, max=10, message="최소 5개 최대 10개 입니다.")
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @Min(11)
    private String tel;
    @Min(8)
    private String birth;
    private Date rdate;
    private int valid;

    public Member(String email, String password, String name, String tel, String birth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.birth = birth;
    }
}
