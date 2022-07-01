package com.ccoins.users.service;

import com.ccoins.users.dto.OwnerDTO;

import java.util.Optional;

public interface IOwnerService {
    OwnerDTO saveOrUpdate(OwnerDTO owner);

    Optional<OwnerDTO> findByEmail(String email);

}
