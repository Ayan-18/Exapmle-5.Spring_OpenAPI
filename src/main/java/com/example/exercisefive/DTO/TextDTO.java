package com.example.exercisefive.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextDTO {
    private String id;
    private String text;
    private LocalDateTime registrationDate;
}