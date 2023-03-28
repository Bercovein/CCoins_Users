package com.ccoins.users.service;

import com.ccoins.users.dto.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    ClientDTO saveOrUpdate(ClientDTO request);

    Optional<ClientDTO> findActiveByIp(String ip);

    Optional<ClientDTO> findActiveById(Long id);

    void updateName(ClientDTO request);

    List<ClientDTO> findByIdIn(List<Long> list);

    List<ClientDTO> findByParty(Long partyId);
}
