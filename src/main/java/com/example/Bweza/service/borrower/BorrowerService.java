package com.example.Bweza.service.borrower;

import com.example.Bweza.modal.Borrower;

import java.util.List;

public interface BorrowerService {
    public  List<Borrower> getBorrowers();

    public  Borrower createBorrower(Borrower borrower);
}
