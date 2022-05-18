package com.ccoins.Users.controller;

import com.ccoins.Users.dto.owner.OwnerDTO;
import com.ccoins.Users.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private IOwnerService service;

    @PostMapping
    void saveOwner(@RequestBody OwnerDTO owner) {
        this.service.saveOrUpdate(owner);
    }

    @GetMapping("/email/{email}")
    Optional<OwnerDTO> findByEmail(@PathVariable("email") String email) {
        return this.service.findByEmail(email);
    }

}
