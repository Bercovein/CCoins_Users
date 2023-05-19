package com.ccoins.users.repository;

import com.ccoins.users.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query(value = "UPDATE Client c SET c.nickName = :nickName WHERE c.ip = :ip")
    void updateNickNameById(@Param("nickName") String nickName,@Param("ip") String ip);

    List<Client> findByIdIn(List<Long> list);

    @Query(value = "select c.* from clients c " +
            "inner join clients_parties cp on cp.fk_client = c.id " +
            "where cp.FK_PARTY = :partyId",nativeQuery = true)
    List<Client> findByParty(@Param("partyId") Long partyId);
}
