package org.cap.transactionmgt.service;

import org.cap.transactionmgt.entities.WalletTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;


public interface IWalletTransactionService {

	WalletTransaction addAmount(WalletAccount account,double amount);
	
	WalletTransaction deductAmount(WalletAccount account,double amount);
	
	void transferAmount(WalletAccount account_from,WalletAccount account_to,double amount);
	
}
