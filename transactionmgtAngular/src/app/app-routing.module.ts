import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddTransactionComponent } from './add-transaction/add-transaction.component';
import { ShowTransactionsComponent } from './show-transactions/show-transactions.component';
import { FetchbyidTransactionComponent } from './fetchbyid-transaction/fetchbyid-transaction.component';


const routes: Routes = [
  {
    path:'add-transaction',
    component:AddTransactionComponent
  },
  
  {
   path:'show-transactions',
   component:ShowTransactionsComponent
  }
  ,
  {
    path:'fetchbyid-transaction',
    component:FetchbyidTransactionComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
