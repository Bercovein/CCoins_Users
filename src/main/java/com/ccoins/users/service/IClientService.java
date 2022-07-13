package com.ccoins.users.service;

import com.ccoins.users.dto.ClientDTO;

import java.util.Optional;

public interface IClientService {
    ClientDTO saveOrUpdate(ClientDTO request);

    Optional<ClientDTO> findActiveByIp(String id);
}
