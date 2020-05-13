package org.cap.transactionmgt.service;

import org.cap.transactionmgt.entities.WalletTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;


public interface IWalletTransactionService {

	WalletTransaction save(WalletTransaction transaction);
    WalletTransaction findById(int id);
    List<WalletTransaction> fetchAll();
    boolean deleteTransaction(int id);
}
