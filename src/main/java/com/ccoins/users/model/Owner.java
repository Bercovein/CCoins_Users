package com.ccoins.users.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="sptf_refresh_token")
    private String refreshTokenSPTF;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Builder
    public Owner(Long id, String email, LocalDateTime startDate, String refreshTokenSPTF) {
        this.id = id;
        this.email = email;
        this.startDate = startDate;
        this.refreshTokenSPTF = refreshTokenSPTF;
    }
}
