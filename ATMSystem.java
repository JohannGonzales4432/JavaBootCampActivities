package m4.activity2;

public class ATMSystem {
	
	private double[] accounts = {10000, 15000, 20000};

	public ATMSystem() {
	
	}
	
	public void processWithdrawal(String accountIndex, String amountInput) {
		
		int index;
		double balance;
		double amount;
		
		try {
			index = Integer.parseInt(accountIndex);
			
			balance = this.accounts[index];
			
			amount = Double.parseDouble(amountInput);
			
			System.out.println("Current Balance: P" + balance);
			System.out.println("Withdrawal: P" + amount);
			
			if(amount > balance) {
				System.out.println("Insufficient funds Cannot Withdraw");
			}
			else {
				
				balance = balance - amount;
				
				System.out.println("New balance: P" + balance);
				System.out.println("Withdrawal successful!");
				
			}
		}catch(NumberFormatException e) {
			System.out.println("Error: Invalid input");
			System.out.println("Please enter valid numbers.");
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Account not found");
			System.out.println("Invalid account index");
			
		}catch(Exception e) {
			System.out.println("Error: Transaction Failed");
			
		}
		
		
		
		
	}
}
