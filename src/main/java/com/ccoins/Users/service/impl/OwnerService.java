package com.ccoins.Users.service.impl;

import com.ccoins.Users.dto.owner.OwnerDTO;
import com.ccoins.Users.model.Owner;
import com.ccoins.Users.repository.IOwnerRepository;
import com.ccoins.Users.service.IOwnerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OwnerService implements IOwnerService {

    @Autowired
    private IOwnerRepository ownerRepository;


    @Override
    public void saveOrUpdate(OwnerDTO ownerDTO) {

        Owner owner;

        ModelMapper mapper = new ModelMapper();
        owner = mapper.map(ownerDTO, Owner.class);
        this.ownerRepository.save(owner);

    }

    @Override
    public Optional<OwnerDTO> findByEmail(String email) {

        Optional<Owner> ownerOpt = this.ownerRepository.findByEmail(email);
        Optional<OwnerDTO> response = Optional.empty();

        if(ownerOpt.isPresent()){
            ModelMapper mapper = new ModelMapper();
            response = Optional.of(mapper.map(ownerOpt, OwnerDTO.class));
        }

        return response;
    }
}
