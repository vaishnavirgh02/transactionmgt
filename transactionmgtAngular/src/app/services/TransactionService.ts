import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WalletTransaction } from '../model/WalletTransaction';

import { HttpHeaders, HttpClient } from '@angular/common/http';
const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

@Injectable()
export class TransactionService{
    client: HttpClient;

    constructor(client: HttpClient){
        this.client=client;
    }

    WalletTransactionUrl="http://localhost:8086/transactions/"

    addTransaction(trans: WalletTransaction): Observable<WalletTransaction>{
        
        let url=this.WalletTransactionUrl + "add";
        let result: Observable<WalletTransaction> = this.client.post<WalletTransaction>(url, trans);
        return result;
    }

    fetchAllTransaction(): Observable<WalletTransaction[]>{
      
        let url=this.WalletTransactionUrl;
        let observable: Observable<WalletTransaction[]> = this.client.get<WalletTransaction[]>(url);
        return observable;
    }

    findTransactionById(id: number): Observable<WalletTransaction>{
        let url = this.WalletTransactionUrl + "getbyid/" + id;
        let observable: Observable<WalletTransaction> = this.client.get<WalletTransaction>(url);
        return observable;
    }
}
