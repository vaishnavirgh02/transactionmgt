package org.cap.transactionmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.cap.transactionmgt.entities.WalletTransaction;

@Repository
public interface WalletTransactionDao extends JpaRepository<WalletTransaction,Integer> {

	WalletTransaction addAmount(WalletAccount account,double amount);
	
	WalletTransaction deductAmount(WalletAccount account,double amount);
	
	void transferAmount(WalletAccount account_from,WalletAccount account_to,double amount);
	
}
