package com.ccoins.users.controller.swagger;

import com.ccoins.users.dto.ClientDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Api(tags = "Client")
public interface IClientController {

    @ApiOperation(value = "Find by ip",
            notes = "Find a client by ip")
    Optional<ClientDTO> findByIp(@PathVariable("ip") String ip);

    @ApiOperation(value = "Update name")
    void updateName(@RequestBody ClientDTO request);

    @ApiOperation(value = "Find client by id list")
    List<ClientDTO> findByIdIn(@RequestBody List<Long> list);
}