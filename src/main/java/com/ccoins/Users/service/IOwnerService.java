package com.ccoins.Users.service;

import com.ccoins.Users.dto.OwnerDTO;

import java.util.Optional;

public interface IOwnerService {
    OwnerDTO saveOrUpdate(OwnerDTO owner);

    Optional<OwnerDTO> findByEmail(String email);

}
