package com.example.fullhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Comments {

    private int id;
    private String comment;
    private User user;
    private Tool tool;
    private Instant craetedAt;

}
