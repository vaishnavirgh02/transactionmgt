package org.cap.empmgt;

import java.util.List;

import javax.persistence.EntityManager;

import org.cap.transactionmgt.entities.WalletTransaction;
import org.cap.transactionmgt.exception.TransactionNotFoundException;
import org.cap.transactionmgt.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(WalletTransactionServiceImpl.class)


@SpringBootTest
class TransactionmgtServiceImplTests {

	@Autowired
	private IWalletTransactionService transactionService;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSave_1()
	{
	WalletTransaction transaction = new WalletTransaction();
	transaction. setAccountbalance(100.0);
	transaction. setAmount(2000);
	transaction.setDescription("Credit");
	
	WalletTransaction result = transactionService.save(transaction);
	List<WalletTransaction> fetched = entityManager.createQuery("from WalletTransaction").getResultList();
	Assertions.assertEquals(1, fetched.size());// verifying one got inserted
	WalletTransaction expected = fetched.get(0);
	Assertions.assertEquals(expected, result);// verifying fetch and stored are equal
	  }
	
	@Test
	public void testfindByIdTransaction_1() {
		WalletTransaction  transaction= new WalletTransaction();

		transaction. setAccountbalance(100.0);
		transaction. setAmount(2000);
		transaction.setDescription("transactionCredit");
		
		transaction = entityManager.merge(transaction);
        int transactionid = transaction. getTransactionid();
        WalletTransaction result = transactionService.findById(transactionid);
        Assertions.assertEquals(transaction, result);
	}
	
	 /**
     * case when transaction doesn't exist , verifying TransactionNotFoundException is thrown
     */
    @Test
    public void testfindByIdTransaction_2() {
        Executable executable = () -> transactionService.findById(3);
        Assertions.assertThrows(TransactionNotFoundException.class, executable);

    }
	
	@Test
	public void testGetAllTransaction() {
		
		List< WalletTransaction> expected = entityManager.createQuery("from  WalletTransaction").getResultList();
        List< WalletTransaction> result = transactionService.fetchAll();
        System.out.println(expected);
        System.out.println(result);
        Assertions.assertEquals(expected, result);
	}
	

}
