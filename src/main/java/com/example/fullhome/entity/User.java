package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private int phone;
    private String password;
    private Role role;
    private Instant createdAt;
    private Instant updatedAt;

}
