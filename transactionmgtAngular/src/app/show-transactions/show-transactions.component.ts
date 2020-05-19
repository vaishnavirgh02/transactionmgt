import { Component, OnInit } from '@angular/core';

import { WalletTransaction } from '../model/WalletTransaction';
import { TransactionService } from '../services/TransactionService';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-show-transactions',
  templateUrl: './show-transactions.component.html',
  styleUrls: ['./show-transactions.component.css']
})
export class ShowTransactionsComponent implements OnInit {

  transactions: WalletTransaction[] = [];

  service: TransactionService;

  orderByField: string = null;

  
  constructor(service: TransactionService) {
      this.service = service;
      let observable: Observable<WalletTransaction[]> = this.service.fetchAllTransaction();

      observable.subscribe(
          trans=>{
              this.transactions = trans;
              console.log("inside success callback = "+this.transactions.length);
          },
          err=>console.log(err)    
      );
  }

  ngOnInit(): void {
  }
}
