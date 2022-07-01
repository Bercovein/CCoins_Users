package com.ccoins.users.controller;

import com.ccoins.users.dto.ClientDTO;
import com.ccoins.users.service.IClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            notes = "Find a client by id")
    @GetMapping("/{id}")
    Optional<ClientDTO> findById(@PathVariable("id") Long id) {
        return this.service.findActiveById(id);
    }

}
