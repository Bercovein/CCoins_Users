package com.ccoins.users.controller;

import com.ccoins.users.controller.swagger.IClientController;
import com.ccoins.users.dto.ClientDTO;
import com.ccoins.users.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController implements IClientController {

    private final IClientService service;

    @Autowired
    public ClientController(IClientService service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public ClientDTO save(@RequestBody ClientDTO request) {
        return this.service.saveOrUpdate(request);
    }

    @GetMapping("/ip/{ip}")
    @Override
    public Optional<ClientDTO> findByIp(@PathVariable("ip") String ip) {
    return this.service.findActiveByIp(ip);
    }

    @PutMapping("/name")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void updateName(@RequestBody ClientDTO request) {
        this.service.updateName(request);
    }

    @PostMapping("/list")
    @Override
    public List<ClientDTO> findByIdIn(@RequestBody List<Long> list){
        return this.service.findByIdIn(list);
    }

    @GetMapping("/party/{partyId}")
    @Override
    public ResponseEntity<List<ClientDTO>> findByParty(@PathVariable("partyId") Long partyId) {
        return ResponseEntity.ok(this.service.findByParty(partyId));
    }

    @GetMapping("/party/{partyId}/active")
    @Override
    public ResponseEntity<List<ClientDTO>> findActivesByParty(@PathVariable("partyId") Long partyId) {
        return ResponseEntity.ok(this.service.findActivesByParty(partyId));
    }
}
