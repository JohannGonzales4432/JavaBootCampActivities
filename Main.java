package m4.activity5;

public class Main {
	
	public static AccountValidator validator;
	
	public static void testValidation(String input) {
		
		try {
			validator.validateAccountNumber(input);
		}catch(InvalidAccountNumberException e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}catch(InvalidAccountFormatException e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}catch(NullPointerException e) {
			
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		validator = new AccountValidator();
		
		System.out.println("=== Account Number Validation Test ===");
		System.out.println();
		
		System.out.println("Test 1: Valid account (1234567890)");
		testValidation("1234567890");
		System.out.println();
		
		System.out.println("Test 2: Too Short (123)");
		testValidation("123");
		System.out.println();
		
		System.out.println("Test 3: Contains letters (12345ABCDE)");
		testValidation("12345ABCDE");
		System.out.println();
		
		System.out.println("Test 34: Contains space (12345 7890)");
		testValidation("12345 7890");
		System.out.println();
		
		System.out.println("Test 5: Null value");
		testValidation(null);
	}

}
