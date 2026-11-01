package com.example.Bweza.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Borrower {

    @Id
    @GeneratedValue
    private  Long Id;
    private  String firstName;
    private  String lastName;
    private  double creditAmount;
    private  String note;
    private  LocalDate createdAt;
    private  LocalDate updatedAt;
    private  LocalDate dueDate;


    @Enumerated(EnumType.STRING)
    private  CreditStatus creditStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
