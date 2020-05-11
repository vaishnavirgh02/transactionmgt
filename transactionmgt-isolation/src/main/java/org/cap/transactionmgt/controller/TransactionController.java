package org.cap.transactionmgt.controller;

import org.cap.transactionmgt.dto.*;
import org.cap.transactionmgt.entities.*;
import org.cap.transactionmgt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private IWalletTransactionService service;


  


}
