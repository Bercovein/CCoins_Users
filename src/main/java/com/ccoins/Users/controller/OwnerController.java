package com.ccoins.Users.controller;

import com.ccoins.Users.dto.OwnerDTO;
import com.ccoins.Users.service.IOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Find by email",
            notes = "Find a owner by email")
    @GetMapping("/email/{email}")
    Optional<OwnerDTO> findByEmail(@PathVariable("email") String email) {
        return this.service.findByEmail(email);
    }


}
