package org.cap.transactionmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.cap.transactionmgt.entities.WalletTransaction;

@Repository
public interface WalletTransactionDao extends JpaRepository<WalletTransaction,Integer> {

	
	
}
