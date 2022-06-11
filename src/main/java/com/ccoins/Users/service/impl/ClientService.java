package com.ccoins.Users.service.impl;

import com.ccoins.Users.dto.ClientDTO;
import com.ccoins.Users.exceptions.UnauthorizedException;
import com.ccoins.Users.model.Client;
import com.ccoins.Users.repository.IClientRepository;
import com.ccoins.Users.service.IClientService;
import com.ccoins.Users.utils.ErrorUtils;
import com.ccoins.Users.utils.MapperUtils;
import com.ccoins.Users.utils.constant.ExceptionConstant;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ClientService implements IClientService {

    private final IClientRepository repository;

    @Autowired
    public ClientService(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientDTO saveOrUpdate(ClientDTO request) {

        Client client;

        try {
            ModelMapper mapper = new ModelMapper();
            client = mapper.map(request, Client.class);
            client = this.repository.save(client);
            return mapper.map(client,ClientDTO.class);
        }catch(Exception e){
            log.error(ErrorUtils.parseMethodError(this.getClass()));
            throw new UnauthorizedException(ExceptionConstant.USERS_NEW_OWNER_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_NEW_OWNER_ERROR);
        }

    }

    @Override
    public Optional<ClientDTO> findById(Long id) {

        Optional<Client> client;
        ClientDTO clientDTO = null;
        try {
            client = this.repository.findById(id);
            if(client.isPresent()){
                clientDTO = (ClientDTO)MapperUtils.map(client, ClientDTO.class);
            }
            return Optional.of(clientDTO);
        }catch(Exception e){
            log.error(ErrorUtils.parseMethodError(this.getClass()));
            throw new UnauthorizedException(ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR);
        }
    }

}
