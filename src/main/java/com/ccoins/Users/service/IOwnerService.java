package com.ccoins.Users.service;

import com.ccoins.Users.dto.OwnerDTO;
import com.ccoins.Users.model.projection.IPOwner;

import java.util.Optional;

public interface IOwnerService {
    IPOwner saveOrUpdate(OwnerDTO owner);

    Optional<IPOwner> findByEmail(String email);

}
