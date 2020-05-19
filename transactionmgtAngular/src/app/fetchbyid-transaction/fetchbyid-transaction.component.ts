import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { WalletTransaction } from '../model/WalletTransaction';
import { TransactionService } from '../services/TransactionService';

@Component({
  selector: 'app-fetchbyid-transaction',
  templateUrl: './fetchbyid-transaction.component.html',
  styleUrls: ['./fetchbyid-transaction.component.css']
})
export class FetchbyidTransactionComponent implements OnInit {

  service:TransactionService;

  foundTransaction:WalletTransaction=null;
  foundStatus=null;
  constructor(service:TransactionService) {
    this.service=service;
   }


  ngOnInit(): void {
  }

  findTransactionById(form:any):void{
    let details=form.value;
    let id=details.transactionid;
    let fetched:Observable<WalletTransaction> =this.service.findTransactionById(id);
   fetched.subscribe(
    transaction=>{
    this.foundTransaction=transaction; 
    this.foundStatus="found";
     },
    err=>{
      this.foundStatus="notfound";
     console.log("err while fetching transaction="+err);  
     }
   );    
  
  }



}
