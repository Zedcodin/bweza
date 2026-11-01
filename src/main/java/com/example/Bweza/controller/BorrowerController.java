package com.example.Bweza.controller;


import com.example.Bweza.dtos.BorrowersDto;
import com.example.Bweza.modal.Borrower;
import com.example.Bweza.service.borrower.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BorrowerController {

    //borrower service
    @Autowired
    private BorrowerService borrowerService;


    //get borrowers
    @GetMapping("/borrower")
    public ResponseEntity<List<Borrower>> getBorrowers(){

        List<Borrower> borrower = borrowerService.getBorrowers();

        return  ResponseEntity.ok(borrower);
    }

    //create borrower
    @PostMapping("/borrower")
    public ResponseEntity<BorrowersDto> createBorrower(@RequestBody Borrower borrower){

        try {
            Borrower createdBorrower = borrowerService.createBorrower(borrower);
            BorrowersDto borrowersDto = new BorrowersDto(
                    createdBorrower.getId(),
                    createdBorrower.getFirstName(),
                    createdBorrower.getLastName(),
                    createdBorrower.getCreditAmount()


            );
            System.out.println(borrowersDto);

            return ResponseEntity.ok(borrowersDto);

        } catch (RuntimeException e) {
            //throw new RuntimeException(e);
            return  ResponseEntity.internalServerError().build();
        }

    }


}
