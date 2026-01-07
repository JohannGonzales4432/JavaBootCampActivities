package m4.activity1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount bankAccount = new BankAccount();
		
		System.out.println("=== Bank Account Name Display ===");
		System.out.println();
		
		bankAccount.testCase("ACC-001");
		bankAccount.testCase("ACC-999");
		
		System.out.println("=== Program completed successfully! ===");
	}

}
