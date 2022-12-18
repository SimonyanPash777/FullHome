package com.example.fullhome.repository;

import com.example.fullhome.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
}
