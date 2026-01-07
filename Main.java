package m4.activity3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ATMTransaction atm = new ATMTransaction();
		System.out.println("ATM BALANCE INQUIRY SYSTEM ===");
		System.out.println();
		
		System.out.println("--- TEST CASE 1 VALID SAVING ACCOUNT ---");
		System.out.println();
		atm.checkBalance("100123456", 15000.00);
		
		System.out.println("--- TEST CASE 2 VALID CHECKING ACCOUNT ---");
		System.out.println();
		atm.checkBalance("200987654", 25000.00);
		
		System.out.println("--- TEST CASE 3 INVALID ACCOUNT NUMBER FORMAT ---");
		System.out.println();
		atm.checkBalance("ABC12345", 15000.00);
		
		System.out.println("--- TEST CASE 4 EMPTY ACCOUNT NUMBER ---");
		System.out.println();
		atm.checkBalance("", 15000.00);
	}

}
