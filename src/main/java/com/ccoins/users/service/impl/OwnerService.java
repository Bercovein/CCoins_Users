package com.ccoins.users.service.impl;

import com.ccoins.users.dto.OwnerDTO;
import com.ccoins.users.dto.RefreshTokenDTO;
import com.ccoins.users.exceptions.BadRequestException;
import com.ccoins.users.model.Owner;
import com.ccoins.users.repository.IOwnerRepository;
import com.ccoins.users.service.IOwnerService;
import com.ccoins.users.utils.constant.ExceptionConstant;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
            throw new BadRequestException(ExceptionConstant.USERS_NEW_OWNER_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_NEW_OWNER_ERROR);
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
            throw new BadRequestException(ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR);
        }
    }

    @Override
    public ResponseEntity<RefreshTokenDTO> getSpotifyRefreshTokenByOwnerId(Long id) {

        Optional<Owner> ownerOpt;
        RefreshTokenDTO response = RefreshTokenDTO.builder().refreshToken(null).build();

        try {
            ownerOpt = this.ownerRepository.findById(id);
        }catch(Exception e){
            return ResponseEntity.ok(response);
        }

        if(ownerOpt.isPresent()){
            Owner owner = ownerOpt.get();
            response.setRefreshToken(owner.getRefreshTokenSPTF());
        }

        return ResponseEntity.ok(response);
    }

    @Override
    public void saveOrUpdateRefreshTokenSpotify(Long id, RefreshTokenDTO request) {

        try{
            this.ownerRepository.updateRefreshTokenSpotify(id, request.getRefreshToken());
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.SPOTIFY_REFRESH_TOKEN_UPDATE_ERROR_CODE,
                    this.getClass(), ExceptionConstant.SPOTIFY_REFRESH_TOKEN_UPDATE_ERROR);
        }
    }
}
