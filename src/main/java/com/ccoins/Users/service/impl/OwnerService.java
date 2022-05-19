package com.ccoins.Users.service.impl;

import com.ccoins.Users.dto.owner.OwnerDTO;
import com.ccoins.Users.exceptions.UnauthorizedException;
import com.ccoins.Users.model.Owner;
import com.ccoins.Users.repository.IOwnerRepository;
import com.ccoins.Users.service.IOwnerService;
import com.ccoins.Users.utils.ErrorUtils;
import com.ccoins.Users.utils.constant.ExceptionConstant;
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
    public OwnerDTO saveOrUpdate(OwnerDTO ownerDTO) {

        Owner owner;

        try {
            ModelMapper mapper = new ModelMapper();
            owner = mapper.map(ownerDTO, Owner.class);
            owner = this.ownerRepository.save(owner);
            return mapper.map(owner, OwnerDTO.class);
        }catch(Exception e){
            log.error(ErrorUtils.parseMethodError(this.getClass()));
            throw new UnauthorizedException(ExceptionConstant.USERS_NEW_OWNER_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_NEW_OWNER_ERROR);
        }

    }

    @Override
    public Optional<OwnerDTO> findByEmail(String email) {

        Optional<Owner> ownerOpt = this.ownerRepository.findByEmail(email);
        Optional<OwnerDTO> response = Optional.empty();
        try {
            if(ownerOpt.isPresent()){
                ModelMapper mapper = new ModelMapper();
                response = Optional.of(mapper.map(ownerOpt, OwnerDTO.class));
            }
            return response;
        }catch(Exception e){
            log.error(ErrorUtils.parseMethodError(this.getClass()));
            throw new UnauthorizedException(ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR);
        }
    }

}
