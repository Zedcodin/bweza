package com.example.Bweza.controller;

import com.example.Bweza.modal.Borrower;
import com.example.Bweza.service.borrower.BorrowerService;
import com.example.Bweza.service.creditService.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CreditController {

    //borrower service
    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private CreditService creditService;
    //create borrower
    @PostMapping("/credit/repay/{id}")
    public Borrower repayCredit(@RequestBody Borrower borrower, @PathVariable("id") Long id){

        Borrower updatedBorrowerData = creditService.repayCredit(borrower, id);

        return updatedBorrowerData;
    }
}

