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
public class Notification {
    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name =  "user_id")
    private User user;
    private  String notificationMessage;
    private LocalDate createdAt;
    private LocalDate updateAt;

    @Enumerated(EnumType.STRING)
    private  NotificationType notificationType;

}
