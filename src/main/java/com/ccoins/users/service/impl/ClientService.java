package com.ccoins.users.service.impl;

import com.ccoins.users.dto.ClientDTO;
import com.ccoins.users.exceptions.BadRequestException;
import com.ccoins.users.model.Client;
import com.ccoins.users.model.projections.IPClient;
import com.ccoins.users.repository.IClientRepository;
import com.ccoins.users.service.IClientService;
import com.ccoins.users.utils.DateUtils;
import com.ccoins.users.utils.constant.ExceptionConstant;
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
            client.setStartDate(DateUtils.now());
            client = this.repository.save(client);
            return mapper.map(client,ClientDTO.class);
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.USERS_NEW_OWNER_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_NEW_OWNER_ERROR);
        }

    }

    @Override
    public Optional<IPClient> findActiveByIp(String id) {

        try {
            return this.repository.findByIp(id);
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR);
        }
    }

    @Override
    public void updateName(ClientDTO request) {
        try {
            this.repository.updateNickNameByIp(request.getNickName(), request.getIp());
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.UPDATE_CLIENT_NAME_ERROR_CODE,
                    this.getClass(), ExceptionConstant.UPDATE_CLIENT_NAME_ERROR);
        }
    }

}
