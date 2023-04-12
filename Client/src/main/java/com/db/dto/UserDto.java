package com.db.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    int id;
    //private Wallet wallet;
    String name;
    String email;
    String password;
}
