package com.ccoins.Users.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String email;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Builder
    public Owner(Long id, String email, LocalDateTime startDate) {
        this.id = id;
        this.email = email;
        this.startDate = startDate;
    }
}
