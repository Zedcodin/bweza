package com.example.Bweza.dtos;

import com.example.Bweza.modal.CreditStatus;
import com.example.Bweza.modal.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record BorrowersDto(
          Long Id,
          String    firstName,
          String    lastName,
          double    creditAmount
 

) {}
