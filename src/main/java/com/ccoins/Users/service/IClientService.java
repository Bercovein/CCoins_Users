package com.ccoins.Users.service;

import com.ccoins.Users.dto.ClientDTO;

import java.util.Optional;

public interface IClientService {
    ClientDTO saveOrUpdate(ClientDTO request);

    Optional<ClientDTO> findById(Long id);

}
