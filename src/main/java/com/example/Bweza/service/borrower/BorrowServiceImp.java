package com.example.Bweza.service.borrower;

import com.example.Bweza.modal.Borrower;
import com.example.Bweza.modal.CreditStatus;
import com.example.Bweza.modal.User;
import com.example.Bweza.repository.borrower.BorrowerRepository;
import com.example.Bweza.repository.user.UserRepository;
import com.example.Bweza.service.utilServices.SendNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImp implements  BorrowerService{


    //borrowers repository
    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendNotificationService sendNotificationService;

    @Override
    public List<Borrower> getBorrowers() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower createBorrower(Borrower borrower) {

        Long Id = borrower.getUser().getId();
        System.out.println(Id);

        User user = userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Failed to find user"));


        borrower.setUser(user);

        borrower.setCreditStatus(CreditStatus.PENDING);

        Borrower createdBorrower = borrowerRepository.save(borrower);

        //send notification

        sendNotificationService.sendCreditNotificationMessage(user, "Hello this is a credit notification");


        return createdBorrower;
    }
}

