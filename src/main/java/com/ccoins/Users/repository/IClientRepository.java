package com.ccoins.Users.repository;

import com.ccoins.Users.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);

    Client save(Client request);
}
