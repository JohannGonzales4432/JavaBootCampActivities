package m3.activity3;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		Map<String, Integer> products = new HashMap<>();
		
		String inputLine;
		char choice;
		String stringInput;
		Integer intInput;
		
		products.put("Mouse", 5);
		products.put("Monitor", 7);
		products.put("Keyboard", 3);
		products.put("Webcam", 12);
		products.put("Laptop", 8);
		
		do {
			
			displayMenu();
			
			inputLine = input.nextLine();
			choice = inputLine.charAt(0);
			
			switch(choice) {
			
				case '1':{
					
					System.out.println("Enter a product to search: ");
					
					stringInput = input.nextLine();
					
					
					if (isExistingProduct(products,stringInput)) {
						System.out.println("Product found");
					}else {
						System.out.println("Product not found");
					}
					
					break;
				}
				case '2':{
					
					String productName;
					String productPrice;
					
					System.out.println("Enter product name to add: ");
					productName = input.nextLine();
					
					System.out.println("Enter price:");
					productPrice = input.nextLine();
					
					products.put(productName, Integer.parseInt(productPrice));
					
					System.out.println("Product added: " + productName);
					
					break;
					
				}
				case '3':{
					
					System.out.println("All products and prices");
					
					for (Map.Entry<String, Integer> i : products.entrySet()) {
						System.out.println(i.getKey() + " - " + i.getValue());
					}
					break;
				}
				case '4':{
					
					Integer lowestPrice = Integer.MAX_VALUE;
					String  lowestName = "";
					for (Map.Entry<String, Integer> i : products.entrySet()) {
						
						if(i.getValue() < lowestPrice) {
							lowestPrice = i.getValue();
							lowestName = i.getKey();
						}
					}
					
					System.out.println("Cheapest Product: " + lowestName + " - " + lowestPrice);
					
					
					break;
				}
				default:{
					System.out.println("Enter proper input");
				}
			}
			
		}while(choice != 5);
	}
	
	public static void displayMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Search a product");
		System.out.println("2. Add a product");
		System.out.println("3. Print all products and prices");
		System.out.println("4. Find the Cheapest product");
		System.out.println("5. Exit");
	}
	
	public static boolean isExistingProduct(Map<String, Integer> products, String findString) {
		return products.containsKey(findString);
	}
	


}
