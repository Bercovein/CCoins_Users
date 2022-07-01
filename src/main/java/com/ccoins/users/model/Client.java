package com.ccoins.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static com.ccoins.users.utils.DateUtils.AUTO_DATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Client")
@Table(name = "clients")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="NICK_NAME", unique = true)
    @NotEmpty
    private String nickName;

    @Column(name="active", columnDefinition = "boolean default true")
    private boolean active;

    @Column(name="start_date",insertable = false, updatable = false,
            columnDefinition = AUTO_DATE)
    private LocalDateTime startDate;

}
