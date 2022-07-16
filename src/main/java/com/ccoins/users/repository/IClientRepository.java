package com.ccoins.users.repository;

import com.ccoins.users.model.Client;
import com.ccoins.users.model.projections.IPClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {


    Optional<IPClient> findByIp(String ip);

    Client save(Client request);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Client c SET c.nickName = :nickName WHERE c.ip = :ip")
    void updateNickNameByIp(String nickName, String ip);
}
