package org.cap.transactionmgt.controller;

import org.cap.transactionmgt.dto.*;
import org.cap.transactionmgt.entities.*;
import org.cap.transactionmgt.exception.TransactionNotFoundException;
import org.cap.transactionmgt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/transactions")
@Validated
public class TransactionRestController {

	private static final Logger Log= LoggerFactory.getLogger(TransactionRestController.class);

	
    @Autowired
    private IWalletTransactionService service;

    @PostMapping("/add")
    public ResponseEntity<WalletTransaction>createTransaction(@RequestBody @Valid WalletTransactionDto dto){
	   WalletTransaction transaction=convertFromDto(dto);
        transaction=service.save(transaction);
        ResponseEntity<WalletTransaction>response=new ResponseEntity<>(transaction, HttpStatus.OK);
        return response;
   }

   public WalletTransaction convertFromDto( WalletTransactionDto dto){
	   WalletTransaction transaction=new WalletTransaction();
       transaction.setTransactionid(dto.getTransactionid());
       transaction.setDescription(dto.getDescription());
       transaction.setDateoftransaction(dto.getDateoftransaction());
       transaction.setAmount(dto.getAmount());
       transaction.setAccountbalance(dto.getAccountbalance());
       
       return transaction;
   }
   
   @GetMapping("/getbyid/{id}")
   public ResponseEntity<WalletTransaction>findTransactionById( @PathVariable("id") @Min(1)  int id){
	   WalletTransaction transaction= service.findById(id);
      ResponseEntity<WalletTransaction>response=new ResponseEntity<>(transaction,HttpStatus.OK);
      return response;
   }
   
   @GetMapping("/getbyaccount/{account}")
   public ResponseEntity<List<WalletTransaction>>findTransactionByAccount( @PathVariable("account") @Min(1)  int account){
	   List<WalletTransaction> transactions= service.findByAccount(account);
      ResponseEntity<List<WalletTransaction>>response=new ResponseEntity<>(transactions,HttpStatus.OK);
      return response;
   }
   
  
    @GetMapping
   public ResponseEntity<List<WalletTransaction>>fetchAll(){
       List<WalletTransaction>transaction=service.fetchAll();
       ResponseEntity<List<WalletTransaction>>response=new ResponseEntity<>(transaction,HttpStatus.OK);
       return response;
   }
    
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<String>handleTransactionNotFound(TransactionNotFoundException ex){
        Log.error("Transaction not found exception",ex);
        String msg=ex.getMessage();
        ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        return response;
    }
    
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String>handleAll(Throwable ex){
      Log.error("exception caught",ex);
      String msg=ex.getMessage();
      ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
      return response;
    }
   

  


}
