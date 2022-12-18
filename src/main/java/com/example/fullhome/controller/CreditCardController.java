package com.example.fullhome.controller;

import com.example.fullhome.entity.CreditCard;
import com.example.fullhome.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService creditCardService;

    @PostMapping("/pay")
    public String AddCreditCardPage(@ModelAttribute CreditCard creditCard) {

        creditCardService.saveCreditCard(creditCard);

        return "index";
    }


}
