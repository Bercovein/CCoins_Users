package com.ccoins.Users.service;

import com.ccoins.Users.dto.owner.OwnerDTO;

import java.util.Optional;

public interface IOwnerService {
    void saveOrUpdate(OwnerDTO owner);

    Optional<OwnerDTO> findByEmail(String email);

}
