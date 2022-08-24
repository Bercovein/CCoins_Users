package com.ccoins.users.controller;

import com.ccoins.users.dto.ClientDTO;
import com.ccoins.users.model.projections.IPClient;
import com.ccoins.users.service.IClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@Api(tags = "Client")
public class ClientController {

    @Autowired
    private IClientService service;

    @PostMapping
    ClientDTO save(@RequestBody ClientDTO request) {
        return this.service.saveOrUpdate(request);
    }

    @ApiOperation(value = "Find by id",
            notes = "Find a client by ip")
    @GetMapping("/ip/{id}")
    Optional<IPClient> findByIp(@PathVariable("id") Long ip) {
        return this.service.findActiveById(ip);
    }

    @PutMapping("/name")
    @ResponseStatus(HttpStatus.CREATED)
    void updateName(@RequestBody ClientDTO request) {
        this.service.updateName(request);
    }

    @PostMapping("/list")
    List<ClientDTO> findByIdIn(@RequestBody List<Long> list){
        return this.service.findByIdIn(list);
    }
}
