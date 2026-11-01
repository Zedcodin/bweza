package com.example.Bweza.service.utilServices;

import com.example.Bweza.modal.Notification;
import com.example.Bweza.modal.NotificationType;
import com.example.Bweza.modal.User;
import com.example.Bweza.repository.notification.NotificationRepository;
import com.example.Bweza.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SendNotificationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    public void sendCreditNotificationMessage(User user, String notificationMessage) {
        System.out.println("--- Notification method called ---");

        try {
            Notification notification = new Notification();

            notification.setUser(user);
            notification.setNotificationMessage(
                    notificationMessage
            );
            notification.setCreatedAt(LocalDate.now());
            notification.setUpdateAt(LocalDate.now());
            notification.setNotificationType(
                    NotificationType.CREDIT_NOTIFICATION
            );

            System.out.println("--- Before saving notification ---");

            Notification created_notification =
                    notificationRepository.save(notification);

            System.out.println(
                    "--- Notification saved successfully: "
                            + created_notification.getId() + " ---"
            );

        } catch (Exception e) {
            System.out.println("--- FAILED TO SAVE NOTIFICATION ---");
            e.printStackTrace();
        }
    }

    public void sendCreditReminderNotificationMessage(User user) {
        System.out.println("--- Notification method called ---");

        try {
            Notification notification = new Notification();

            notification.setUser(user);
            notification.setNotificationMessage(
                    "Hello Joshua, your credit repayment reminder."
            );
            notification.setCreatedAt(LocalDate.now());
            notification.setUpdateAt(LocalDate.now());
            notification.setNotificationType(
                    NotificationType.CREDIT_NOTIFICATION
            );

            System.out.println("--- Before saving notification ---");

            Notification created_notification =
                    notificationRepository.save(notification);

            System.out.println(
                    "--- Notification saved successfully: "
                            + created_notification.getId() + " ---"
            );

        } catch (Exception e) {
            System.out.println("--- FAILED TO SAVE NOTIFICATION ---");
            e.printStackTrace();
        }
    }
    
}
