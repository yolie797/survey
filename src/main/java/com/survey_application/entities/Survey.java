package com.survey_application.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    private String contactNumber;
    private String favoriteFood;
    private String[] ratings;
}
