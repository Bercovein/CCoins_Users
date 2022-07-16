package com.ccoins.users.model.projections;

import java.time.LocalDateTime;

public interface IPClient {

    Long getId();
    String getIp();
    String getNickName();
    boolean getActive();
    LocalDateTime getStartDate();

    Long setId();
    String setIp();
    String setNickName();
    boolean setActive();
    LocalDateTime setStartDate();
}
