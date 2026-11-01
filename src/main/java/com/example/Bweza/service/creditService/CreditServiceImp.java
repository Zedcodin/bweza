package com.example.Bweza.service.creditService;

import com.example.Bweza.modal.Borrower;
import com.example.Bweza.modal.CreditStatus;
import com.example.Bweza.modal.User;
import com.example.Bweza.repository.borrower.BorrowerRepository;
import com.example.Bweza.repository.user.UserRepository;
import com.example.Bweza.service.utilServices.SendNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditServiceImp implements  CreditService{
    //borrowers repository
    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendNotificationService sendNotificationService;

    @Override
    public Borrower repayCredit(Borrower borrower, Long id) {
        Long user_id = borrower.getUser().getId();
        System.out.println(user_id);

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("Failed to find user"));

        Borrower existingBorrowerdata = borrowerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Failed to user borroers data"));

        //borrowered amount
        Double borrowedAmount = borrower.getCreditAmount();
        Double existingBorrowedAmount = existingBorrowerdata.getCreditAmount();
        Double balance = existingBorrowedAmount - borrowedAmount;

        if(borrowedAmount >= existingBorrowedAmount){
            System.out.println("-----paid in full-------------");
            existingBorrowerdata.setCreditAmount(0);
            existingBorrowerdata.setCreditStatus(CreditStatus.PAID);
            sendNotificationService.sendCreditNotificationMessage(user, "hello your credit has been paid in full");


        }else {
            System.out.println("-----repayment amount  != existing payment amount");
            existingBorrowerdata.setCreditAmount(balance);
            existingBorrowerdata.setCreditStatus(CreditStatus.PARTIALLY_PAID);
            sendNotificationService.sendCreditNotificationMessage(user, "hello your credit has been partially paid");





        }






        borrower.setUser(user);

        existingBorrowerdata.setUpdatedAt(LocalDate.now());
        existingBorrowerdata.setNote("paid in full");

        // Borrower createdBorrower = borrowerRepository.save(borrower);

        //send notification



        return borrowerRepository.save(existingBorrowerdata);
    }
}
