package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Member {
    private int id;
    private String memberId;

    @NotEmpty(message = "이름은 필수 항목 입니다")
    private String name;

    @Size(min=4, max=10, message="PWD는 최소5개 최대10개 입니다")
    @NotEmpty(message = "PWD는 필수 항목 입니다")
    private String password;
    private Date rdate;

    @Pattern(regexp = "[01]", message = "valid는 1 또는 0이어야 합니다")
    private String valid;
    //1정상, 0비정상
}
