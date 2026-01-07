package m4.activity3;

public class ATMTransaction {
	
	public ATMTransaction() {
		
	}
	
	
	public void checkBalance(String accountNumber, double balance) {
		
		int accountNum;
		char accountType;
		try {
			System.out.println("Processing balance inquiry...");
			
			accountNum = Integer.parseInt(accountNumber);
			
			accountType = accountNumber.charAt(0);
			
			if(accountType == '1') {
				System.out.println("Account Type: Savings");
			}
			if(accountType == '2') {
				System.out.println("Account Type: Checking");
			}
			
			System.out.println("Account Number: " + accountNumber);
			System.out.println("Current Balance: P" + balance);
			System.out.println("Balance inquiry successful!");
			
		}catch(NumberFormatException e) {
			
			System.out.println("Error: Invalid account number format!");
			System.out.println("Account numbers must be numeric");
			
		}catch(StringIndexOutOfBoundsException e) {
			
			System.out.println("Error: Account number is empty or invalid");
			
		}finally {
			System.out.println();
			System.out.println("==========RECEIPT==========");
			System.out.println("Transaction Date: December 3, 2025");
			System.out.println("Transacton Type: Balance Inquiry");
			System.out.println("ATM Location: Main Branch");
			System.out.println("Thank you for banking with us!");
			System.out.println("===========================");
			System.out.println();
		}
	}
}
