package m4.activity2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ATMSystem atm = new ATMSystem();
		
		String index,amount;
		
		System.out.println("=== ATM Withdrawal System ===");
		System.out.println();
		
		index = "1"; 
		amount = "5000";
		
		System.out.println("--- Test 1: Valid Withdrawal ---");
		System.out.println("Account="+index + ", Amount=" + amount);
		atm.processWithdrawal(index, amount);
		
		System.out.println();
		
		index = "abc"; 
		amount = "5000";
		
		System.out.println("--- Test 2: Invalid Account Index ---");
		System.out.println("Account="+index + ", Amount=" + amount);
		atm.processWithdrawal(index, amount);
		
		System.out.println();
		
		index = "10"; 
		amount = "5000";
		
		System.out.println("--- Test 3: Account Not Found ---");
		System.out.println("Account="+index + ", Amount=" + amount);
		atm.processWithdrawal(index, amount);
		
		System.out.println();
		
		index = "1"; 
		amount = "20000";
		
		System.out.println("--- Test 4: Insufficient Funds ---");
		System.out.println("Account="+index + ", Amount=" + amount);
		atm.processWithdrawal(index, amount);
		
		System.out.println();
		
		System.out.println("=== All tests completed! ===");
	}

}
