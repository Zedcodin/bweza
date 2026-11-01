package com.example.Bweza.service.creditService;

import com.example.Bweza.modal.Borrower;
import org.springframework.stereotype.Service;


public interface CreditService {
    public  Borrower repayCredit(Borrower borrower, Long id);
}
