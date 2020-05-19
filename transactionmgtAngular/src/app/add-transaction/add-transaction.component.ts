import { Component, OnInit } from '@angular/core';

import { TransactionService } from '../services/TransactionService';
import { WalletTransaction } from '../model/WalletTransaction';

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {

  service: TransactionService;

  constructor(service: TransactionService){
    this.service = service;
  }

  ngOnInit(): void {
  }

  addedTransaction: WalletTransaction = null;

  addTransaction(form: any){
    let details = form.value;
    this.addedTransaction = new WalletTransaction();
    this.addedTransaction.description = details.description;
    this.addedTransaction.dateoftransaction = details.dateoftransaction;
    this.addedTransaction.amount = details.amount;
    this.addedTransaction.accountbalance = details.accountbalance;

    let result=this.service.addTransaction(this.addedTransaction);
    result.subscribe((transaction: WalletTransaction)=>{
      this.addedTransaction = transaction;
    },
    err=>{
      console.log("err= "+err);
    });

    form.reset();
  }

}
