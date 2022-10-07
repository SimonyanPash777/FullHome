package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Work {

    private int id;
    private Category category;
    private String description;
    private String location;
    private Instant createdAt;
    private String phone;
    private String email;
    private String ptcUrl;
    private String avatarUrl;
    private List<String> pucUrls;

}
