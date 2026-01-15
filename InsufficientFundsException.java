package m4.activity6;

public class InsufficientFundsException extends Exception{
	
	private double balance;
	private double requestedAmount;
	
	public InsufficientFundsException(String message, Double balance, Double requestedAmount) {
		
		super(message);
		
		this.balance = balance;
		this.requestedAmount = requestedAmount;
		
	}
	
	public Double getBalance() {
		return this.balance;
	}
	
	public Double getRequestedAmount() {
		return this.requestedAmount;
	}
}
