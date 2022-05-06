package com.ccoins.Users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner extends User{
    private Long id;
    private String name;
    private String lastname;
    private String password;
}
