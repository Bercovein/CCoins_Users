package com.ccoins.users.repository;

import com.ccoins.users.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByIpAndActive(String ip, boolean bol);

    Client save(Client request);
}
