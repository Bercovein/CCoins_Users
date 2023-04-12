package com.ccoins.users.service;

import com.ccoins.users.dto.OwnerDTO;
import com.ccoins.users.dto.RefreshTokenDTO;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IOwnerService {
    OwnerDTO saveOrUpdate(OwnerDTO owner);

    Optional<OwnerDTO> findByEmail(String email);

    ResponseEntity<RefreshTokenDTO> getSpotifyRefreshTokenByOwnerId(Long id);

    void saveOrUpdateRefreshTokenSpotify(Long id, RefreshTokenDTO request);
}
