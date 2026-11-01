package com.example.Bweza.service.utilServices;

import com.example.Bweza.modal.Borrower;
import com.example.Bweza.modal.CreditStatus;
import com.example.Bweza.modal.User;
import com.example.Bweza.repository.borrower.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutomaticCreditNotificationService {


    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private  SendNotificationService sendNotificationService;

    //@Scheduled(fixedRate = 10000)
    public void checkBorrowers(){

        LocalDate today = LocalDate.now();
        List<Borrower> over_due_borrowers = borrowerRepository.findByCreditStatusAndDueDateLessThanEqual(CreditStatus.PENDING,today);

        for (Borrower borrower : over_due_borrowers){
            System.out.println("--------------items found----------");

            sendNotification(borrower.getUser());

        }

        System.out.println("--------------schedule running----------");
        System.out.println("--------------" + over_due_borrowers + "-----------------");


    }

    private void sendNotification(User user) {
        System.out.println("Sending notification to user ID: " + user.getId());
        sendNotificationService.sendCreditReminderNotificationMessage(user);
    }
}
