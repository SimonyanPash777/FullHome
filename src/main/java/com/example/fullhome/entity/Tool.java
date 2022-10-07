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

public class Tool {

    private int id;
    private String name;
    private String text;
    private String description;
    private double price;
    private Instant createdAt;
    private int count;

}
