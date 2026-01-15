package m4.activity6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m4.activity5.AccountValidator;

@FunctionalInterface
interface BankTestOperation{
	void execute() throws InvalidAmountException, InsufficientFundsException;
}

public class BankAccount {
	
	private double balance;
	private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);
	
	public BankAccount() {
		this.balance = 10000;
	}
	
	
	public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException{
		
		logger.info("Withdrawal requested: P{}", amount);
		
		if(amount < 0 ) {
			logger.error("Invalid withdrawal amount: P{}",amount);
			throw new InvalidAmountException("Withdrawal amount must be positive");
		}
		
		if (amount > balance) {
			logger.warn("Insufficient funds: P{} available", balance);
			throw new InsufficientFundsException("Insufficient funds for withdrawal", this.balance,amount);
		}
		
		this.balance -= amount;
		logger.info("Withdrawal Complete: P{}, New balance: P{}",amount,balance);
		
		
	}
	
	public void deposit(double amount) throws InvalidAmountException{
		
		logger.info("Deposit requested: P{}", amount);
		
		if(amount < 0 ) {
			logger.error("Invalid deposit amount: P{}",amount);
			throw new InvalidAmountException("Deposit amount must be positive");
		}
		
		if (amount > 50000) {
			logger.warn("Large deposit: P{} - requires verificiation", amount);
		}
		
		this.balance += amount;
		logger.info("Deposit Complete: P{}, New balance: P{}",amount,balance);
	}
	
	
	public static void main(String[] args) {
		
		BankAccount account = new BankAccount();
		
		
		runTest(()-> account.deposit(5000),"Deposit");
		runTest(()-> account.withdraw(3000),"Withdrawal");
		runTest(()-> account.deposit(-500),"Deposit");
		runTest(()-> account.withdraw(20000),"Withdrawal");
		runTest(()-> account.deposit(60000),"Deposit");
	}
	
	
	public double getBalance() {
		return this.balance;
	}
	
	public static void runTest(BankTestOperation operation, String operationName) {
		try {
			operation.execute();
		}
		catch(InvalidAmountException e) {
			
			logger.error("{} failed: {}",operationName, e.getMessage(),e);
			
		}
		catch(InsufficientFundsException e) {
			
			logger.error("{} failed: {}",operationName, e.getMessage(),e);
			
		}
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
