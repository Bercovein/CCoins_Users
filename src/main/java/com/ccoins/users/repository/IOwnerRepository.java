package com.ccoins.users.repository;

import com.ccoins.users.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByEmail(String email);

    Owner save(Owner owner);
}
