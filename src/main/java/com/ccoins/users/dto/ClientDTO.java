package com.ccoins.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    private String ip;

    @NotEmpty
    private String nickName;

    private Long id;

    private boolean active;

    private LocalDateTime startDate;
}
