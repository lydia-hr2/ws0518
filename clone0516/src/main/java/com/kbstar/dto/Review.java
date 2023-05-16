package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Review {
    private int id;
    @NotEmpty
    private String userId;
    @NotEmpty
    private String itemId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String review;
    @NotEmpty
    private int rate;

}
