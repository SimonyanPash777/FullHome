package com.example.fullhome.service;

import com.example.fullhome.entity.CreditCard;
import com.example.fullhome.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public void saveCreditCard(CreditCard creditCard){

        creditCardRepository.save(creditCard);
    }

}
