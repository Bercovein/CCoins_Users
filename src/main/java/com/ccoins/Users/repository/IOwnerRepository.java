package com.ccoins.Users.repository;

import com.ccoins.Users.dto.owner.OwnerDTO;
import com.ccoins.Users.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByEmail(String email);
}
