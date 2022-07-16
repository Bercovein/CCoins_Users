package com.ccoins.users.repository;

import com.ccoins.users.model.Client;
import com.ccoins.users.model.projections.IPClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {


    Optional<IPClient> findByIp(String ip);

    Client save(Client request);
}
