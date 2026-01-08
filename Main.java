package m4.activity4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountValidator validator = new AccountValidator();
		
		try {
			validator.validateAccountNumber("1234567890");
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		try {
			validator.validateAccountNumber("123");
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		try {
			validator.validateAccountNumber(null);
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}

}
