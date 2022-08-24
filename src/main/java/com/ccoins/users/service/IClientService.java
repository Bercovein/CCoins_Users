package com.ccoins.users.service;

import com.ccoins.users.dto.ClientDTO;
import com.ccoins.users.model.projections.IPClient;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    ClientDTO saveOrUpdate(ClientDTO request);

    Optional<IPClient> findActiveById(Long id);

    void updateName(ClientDTO request);

    List<ClientDTO> findByIdIn(List<Long> list);
}
