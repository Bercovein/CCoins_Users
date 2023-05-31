package com.ccoins.users.controller;

import com.ccoins.users.controller.swagger.IOwnerController;
import com.ccoins.users.dto.OwnerDTO;
import com.ccoins.users.dto.RefreshTokenDTO;
import com.ccoins.users.service.IOwnerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/owner")
@Api(tags = "Owner")
public class OwnerController implements IOwnerController {

    private final IOwnerService service;

    @Autowired
    public OwnerController(IOwnerService service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public OwnerDTO save(@RequestBody OwnerDTO owner) {
        return this.service.saveOrUpdate(owner);
    }

    @GetMapping("/email/{email}")
    @Override
    public Optional<OwnerDTO> findByEmail(@PathVariable("email") String email) {
        return this.service.findByEmail(email);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<RefreshTokenDTO> getSpotifyRefreshTokenByOwnerId(@PathVariable("id") Long id){
        return this.service.getSpotifyRefreshTokenByOwnerId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void saveOrUpdateRefreshTokenSpotify(@PathVariable("id") Long id, @RequestBody RefreshTokenDTO request){
        this.service.saveOrUpdateRefreshTokenSpotify(id, request);
    }
}
