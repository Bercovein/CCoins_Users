package com.ccoins.Users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Owner extends User{
    private Long id;
    private String name;

    @Builder
    public Owner(String nickName, Long id, String name) {
        super(nickName);
        this.id = id;
        this.name = name;
    }
}
