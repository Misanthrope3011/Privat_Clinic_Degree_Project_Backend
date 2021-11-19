package com.example.demo1.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VerificationToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public VerificationToken(String token, LocalDateTime creationTime, LocalDateTime expirationTime, User user) {
        this.token = token;
        this.creationTime = creationTime;
        this.expirationTime = expirationTime;
        this.user = user;
    }

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private LocalDateTime creationTime;
    private LocalDateTime expirationTime;
    private LocalDateTime confirmationTime;

}