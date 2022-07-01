package com.ccoins.users.service.impl;

import com.ccoins.users.dto.OwnerDTO;
import com.ccoins.users.exceptions.UnauthorizedException;
import com.ccoins.users.model.Owner;
import com.ccoins.users.repository.IOwnerRepository;
import com.ccoins.users.service.IOwnerService;
import com.ccoins.users.utils.ErrorUtils;
import com.ccoins.users.utils.constant.ExceptionConstant;
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
