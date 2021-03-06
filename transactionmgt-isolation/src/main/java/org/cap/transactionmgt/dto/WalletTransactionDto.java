package org.cap.transactionmgt.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class WalletTransactionDto {
	
	
	private int transactionid;
	private String description;
	private LocalDateTime dateoftransaction;
	private double amount;
	private double accountbalance;
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateoftransaction() {
		LocalDateTime ldt=LocalDateTime.now();
		return ldt;
	}
	public void setDateoftransaction(LocalDateTime dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	public WalletTransactionDto() {
		
	}
	
	public WalletTransactionDto(int transactionid,String description,LocalDateTime dateoftransaction,double amount,double accountbalance) {
		this.transactionid=transactionid;
		this.description=description;
		this.dateoftransaction=dateoftransaction;
		this.amount=amount;
		this.accountbalance=accountbalance;
	}
	
	
	
	
}
