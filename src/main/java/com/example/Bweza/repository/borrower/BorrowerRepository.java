package com.example.Bweza.repository.borrower;

import com.example.Bweza.modal.Borrower;
import com.example.Bweza.modal.CreditStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    List<Borrower> findByCreditStatusAndDueDateLessThanEqual(CreditStatus creditStatus, LocalDate duedate);
}
