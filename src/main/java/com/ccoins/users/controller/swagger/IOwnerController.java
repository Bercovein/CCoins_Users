package com.ccoins.users.controller.swagger;

import com.ccoins.users.dto.OwnerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Api(tags = "Client")
public interface IOwnerController {

    @ApiOperation(value = "Save owner")
    OwnerDTO save(@RequestBody OwnerDTO owner);

    @ApiOperation(value = "Find by email",
            notes = "Find a owner by email")
    Optional<OwnerDTO> findByEmail(@PathVariable("email") String email);
}
