package com.ccoins.Users.repository;

import com.ccoins.Users.model.Owner;
import com.ccoins.Users.model.projection.IPOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

    Optional<IPOwner> findByEmail(String email);

    IPOwner save(Owner owner);
}
