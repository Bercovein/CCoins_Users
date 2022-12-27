package com.ccoins.users.service.impl;

import com.ccoins.users.dto.ClientDTO;
import com.ccoins.users.exceptions.BadRequestException;
import com.ccoins.users.model.Client;
import com.ccoins.users.repository.IClientRepository;
import com.ccoins.users.service.IClientService;
import com.ccoins.users.utils.DateUtils;
import com.ccoins.users.utils.MapperUtils;
import com.ccoins.users.utils.constant.ExceptionConstant;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public Optional<ClientDTO> findActiveByIp(String ip) {
        Optional<ClientDTO> clientDto = Optional.empty();
        try {
            Optional<Client> client = this.repository.findByIp(ip);
            if(client.isPresent()){
                clientDto = Optional.ofNullable((ClientDTO)MapperUtils.map(client.get(), ClientDTO.class));
            }
            return clientDto;
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR);
        }
    }

    @Override
    public Optional<ClientDTO> findActiveById(Long id) {
        Optional<ClientDTO> clientDto = Optional.empty();
        try {
            Optional<Client> client = this.repository.findById(id);
            if(client.isPresent()){
                clientDto = Optional.ofNullable((ClientDTO)MapperUtils.map(client.get(), ClientDTO.class));
            }
            return clientDto;
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR_CODE, this.getClass(), ExceptionConstant.USERS_GET_OWNER_BY_EMAIL_ERROR);
        }
    }

    @Override
    public void updateName(ClientDTO request) {
        try {
            this.repository.updateNickNameById(request.getNickName(), request.getId());
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.UPDATE_CLIENT_NAME_ERROR_CODE,
                    this.getClass(), ExceptionConstant.UPDATE_CLIENT_NAME_ERROR);
        }
    }

    @Override
    public List<ClientDTO> findByIdIn(List<Long> list) {
        try {
            List<Client> clients = this.repository.findByIdIn(list);
            List<ClientDTO> response = new ArrayList<>();
            clients.forEach(c -> response.add((ClientDTO) MapperUtils.map(c,ClientDTO.class)));
            return response;
        }catch(Exception e){
            throw new BadRequestException(ExceptionConstant.CLIENT_GET_LIST_ERROR_CODE,
                    this.getClass(), ExceptionConstant.CLIENT_GET_LIST_ERROR);
        }
    }

}
