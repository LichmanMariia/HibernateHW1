package org.itstep;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BankAccountDAOTest {

	private BankAccount bankAccount;
	
	@Before
	public void setUp() throws Exception {
		BankAccount bankAccount = new BankAccount("Alex", "Pupkin", "(099)999-99-99", "pupkin@ukr.net", 1000.0, 500.0, 500.0);
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		bankAccountDAO.saveBankAccount(bankAccount);
	}

	@Test
	public void testSaveBankAccount() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
		assertNotNull(result);
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pupkin", result.getSecondName());
		assertEquals("(099)999-99-99", result.getTelephone());
		assertEquals("pupkin@ukr.net", result.getEmail());
		assertEquals(Double.valueOf(1000.0), result.getCarrency());
		assertEquals(Double.valueOf(500.0), result.getAmount());
		assertEquals(Double.valueOf(500.0), result.getAmountOfCredit());
		
	}
	
	@Test
	public void testUpdateBankAccount() {
		BankAccount bankAccount1 = new BankAccount("Alex", "Petrov", "(066)333-99-11", "petrov@gmail.com", 1600.0, 400.0, 700.0);
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		bankAccountDAO.updateBankAccount(bankAccount1);
		BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
		assertEquals("Alex", result.getFirstName());
		assertEquals("Petrov", result.getSecondName());
		assertEquals("(066)333-99-11", result.getTelephone());
		assertEquals("petrov@gmail.com", result.getEmail());
		
		assertEquals(Double.valueOf(1600), result.getCarrency());
		assertEquals(Double.valueOf(400), result.getAmount());
		assertEquals(Double.valueOf(700), result.getAmountOfCredit());
		
		
				
	}
	
	@Test
	public void testGetBankAccount() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
		assertNotNull(result);
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pupkin", result.getSecondName());
		assertEquals("(099)999-99-99", result.getTelephone());
		assertEquals("pupkin@ukr.net", result.getEmail());
		assertEquals(Double.valueOf(1000.0), result.getCarrency());
		assertEquals(Double.valueOf(500.0), result.getAmount());
		assertEquals(Double.valueOf(500.0), result.getAmountOfCredit());
				
	}
	
	@Test
	public void testDeleteBankAccount() {
	BankAccountDAO bankAccountDAO = new BankAccountDAO();
	bankAccountDAO.deleteBankAccount(bankAccount);
	BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
	assertNull(result);
	}
	
	
	@Test
	public void testGetBankAccountByFirstNameAndSecondName() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount result = bankAccountDAO.getBankAccountByFirstNameAndSecondName(bankAccount.getFirstName(), bankAccount.getSecondName());
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pupkin", result.getSecondName());
			}

	@Test
	public void testGetBankAccountByTelephone() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		List<BankAccount> result = (List<BankAccount>) bankAccountDAO.getBankAccountByTelephone(bankAccount.getTelephone());
		for (BankAccount bankAccountArray : result) {
		assertEquals("(099)999-99-99", bankAccountArray.getTelephone());
		}
	}
	
	@Test
	public void testGetStudentToSecondName() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		List<BankAccount> result = bankAccountDAO.getStudentToSecondName(bankAccount.getSecondName());
		for (BankAccount bankAccountArray : result) {
			assertEquals("Pupkin", bankAccountArray.getSecondName());
		}
	}
	@After
	public void tearDown() throws Exception {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		bankAccountDAO.deleteBankAccount(bankAccount);
	}
}
