package com.ccoins.users.repository;

import com.ccoins.users.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {


    Optional<Client> findById(Long id);

    Optional<Client> findByIp(String ip);
    
    Client save(Client request);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Client c SET c.nickName = :nickName WHERE c.id = :id")
    void updateNickNameById(String nickName, Long id);

    List<Client> findByIdIn(List<Long> list);
}
