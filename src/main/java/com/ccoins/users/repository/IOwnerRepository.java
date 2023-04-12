package com.ccoins.users.repository;

import com.ccoins.users.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByEmail(String email);

    Owner save(Owner owner);

    @Query(value = "update owners o " +
            " set o.SPTF_REFRESH_TOKEN = :refreshToken " +
            " where o.id = :id", nativeQuery = true)
    @Modifying
    @Transactional
    void updateRefreshTokenSpotify(@Param("id") Long id, @Param("refreshToken") String refreshToken);
}
