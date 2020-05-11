package org.cap.transactionmgt.service;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

import org.cap.transactionmgt.service.IWalletTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.cap.transactionmgt.dao.WalletTransactionDao;
import org.cap.transactionmgt.entities.WalletTransaction;

@Service
@Transactional
public class WalletTransactionServiceImpl implements IWalletTransactionService {
	
	@Autowired
    private WalletTransactionDao dao;
	
	//method to store the details of credited amount
	@Override
	public WalletTransaction addAmount(WalletAccount  account, double amount) {
		WalletTransaction transactions=dao.addAmount(account, amount);
		return transactions;        
	}
	
	//method to store the details of deducted amount
	@Override
	public WalletTransaction deductAmount(WalletAccount account, double amount) {
		WalletTransaction transactions=dao.deductAmount(account, amount);
		return transactions;
	}
	
	//method to store the information of transaction from the user account 
	@Override
	public void transferAmount(WalletAccount account_from, WalletAccount account_to,double amount) {
		dao.transferAmount(account_from, account_to, amount);
		
	}
}
