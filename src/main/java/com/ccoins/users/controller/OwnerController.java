package com.ccoins.users.controller;

import com.ccoins.users.dto.OwnerDTO;
import com.ccoins.users.service.IOwnerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/owner")
@Api(tags = "Owner")
public class OwnerController {

    @Autowired
    private IOwnerService service;

    @PostMapping
    OwnerDTO save(@RequestBody OwnerDTO owner) {
        return this.service.saveOrUpdate(owner);
    }

    @GetMapping("/email/{email}")
    Optional<OwnerDTO> findByEmail(@PathVariable("email") String email) {
        return this.service.findByEmail(email);
    }
}
