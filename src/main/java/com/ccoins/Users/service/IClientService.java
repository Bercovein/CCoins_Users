package com.ccoins.Users.service;

import com.ccoins.Users.dto.ClientDTO;
import com.ccoins.Users.model.projection.IPClient;

import java.util.Optional;

public interface IClientService {
    IPClient saveOrUpdate(ClientDTO request);

    Optional<ClientDTO> findById(Long id);

}
