package com.example.softwarearchitecture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    public static final Integer ADMIN = 10;
    @Id
    private Integer id;
    private String account;
    private String password;
    private Integer role;


}
