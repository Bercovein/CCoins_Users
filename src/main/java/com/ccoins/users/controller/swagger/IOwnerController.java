package com.ccoins.users.controller.swagger;

import com.ccoins.users.dto.OwnerDTO;
import com.ccoins.users.dto.RefreshTokenDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Api(tags = "Owner")
public interface IOwnerController {


    @ApiOperation(value = "Save owner")
    OwnerDTO save(@RequestBody OwnerDTO owner);

    @ApiOperation(value = "Find by email")
    Optional<OwnerDTO> findByEmail(@PathVariable("email") String email);

    @ApiOperation(value = "Find refresh_token by owner id",
            notes = "Return true if refresh token exists, false if not or some error")
    ResponseEntity<RefreshTokenDTO> getSpotifyRefreshTokenByOwnerId(@PathVariable("id") Long id);

    @ApiOperation(value = "Update spotify refresh token by owner id",
            notes = "Updates spotify refresh token from one owner by id")
    void saveOrUpdateRefreshTokenSpotify(@PathVariable("id") Long id, @RequestBody RefreshTokenDTO request);
}

