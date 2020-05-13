package org.cap.transactionmgt.service;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.cap.transactionmgt.service.IWalletTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import org.cap.transactionmgt.dao.WalletTransactionDao;
import org.cap.transactionmgt.entities.WalletTransaction;
import org.cap.transactionmgt.exception.TransactionNotFoundException;

@Service
@Transactional
public class WalletTransactionServiceImpl implements IWalletTransactionService {
	
	@Autowired
    private WalletTransactionDao transactionDao;
	
	
	    public void setWalletTransactionDao(WalletTransactionDao dao) {
	        this.transactionDao = dao;
	    }
	    public WalletTransactionDao getWalletTransactionDao() {
	        return transactionDao;
	    }

		@Override
		public WalletTransaction save(WalletTransaction transaction) {
			transaction= transactionDao.save(transaction);
	        return transaction ;

		}

		@Override
		public WalletTransaction findById(int id) {


		     Optional<WalletTransaction>optional=transactionDao.findById(id);
		     if(optional.isPresent()){
		    	 WalletTransaction transaction=optional.get();
		         return transaction ;
		     }
		   
		     throw new TransactionNotFoundException("Transaction not found for id="+id);

		}

		@Override
		public List<WalletTransaction> fetchAll() {

		     List<WalletTransaction>list=  transactionDao.findAll();
		      return list;

		}
		
		@Override
		public boolean deleteTransaction(int id)
		{
			if( transactionDao.existsById(id))
			{
				transactionDao.deleteById(id);
		    }
		return true;
		}
}
