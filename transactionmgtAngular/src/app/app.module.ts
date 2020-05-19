import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTransactionComponent } from './add-transaction/add-transaction.component';
import { ShowTransactionsComponent } from './show-transactions/show-transactions.component';
import { FetchbyidTransactionComponent } from './fetchbyid-transaction/fetchbyid-transaction.component';
import { TransactionService } from './services/TransactionService';


@NgModule({
  declarations: [
    AppComponent,
    AddTransactionComponent,
    ShowTransactionsComponent,
    FetchbyidTransactionComponent,
    ShowTransactionsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [TransactionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
