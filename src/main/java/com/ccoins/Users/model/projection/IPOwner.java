package com.ccoins.Users.model.projection;

import java.time.LocalDateTime;

public interface IPOwner {

    Long getId();
    String getEmail();
    LocalDateTime getStartDate();
}
