package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreditCard {
    private int id;
    private String holderName;
    private String expiresAt;
    private int cardNumber;
    private int cvv;
    private User user;
}
