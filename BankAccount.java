package m4.activity1;

public class BankAccount {
	
	public BankAccount() {
		
	}
	
	public String getAccountName(String accountNumber) {
		
		String name = null;
		
		if (accountNumber == "ACC-001") {
			name = "Juan Dela Cruz";
		}
		
		if (accountNumber == "ACC-002") {
			name = "Maria Santos";
		}
		
		return name;
	}
	
	public void testCase(String accountNumber) {
		
		String name;
		
		System.out.println("Looking up account: " + accountNumber);
		
		try {
			
			name = this.getAccountName(accountNumber);
			
			name = name.toUpperCase();
			
			System.out.println("Account Holder: " + name);
			
		}catch(NullPointerException e) {
			
			System.out.println("Error: Account not found!");
			
		}
		System.out.println();
	}
}
