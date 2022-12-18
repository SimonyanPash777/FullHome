package com.example.fullhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String holderName;
    private String expiresAt;
    private int cardNumber;
    private int cvv;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
}
