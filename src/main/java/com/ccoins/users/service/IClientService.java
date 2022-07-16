package com.ccoins.users.service;

import com.ccoins.users.dto.ClientDTO;
import com.ccoins.users.model.projections.IPClient;

import java.util.Optional;

public interface IClientService {
    ClientDTO saveOrUpdate(ClientDTO request);

    Optional<IPClient> findActiveByIp(String id);
}
