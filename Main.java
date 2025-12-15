package m3.activity2;
import java.util.Scanner;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		HashSet<String> products = new HashSet<String>();
		
		products.add("Laptop");
		products.add("Monitor");
		products.add("Keyboard");
		products.add("Printer");
		products.add("Speaker");
		
		String inputLine;
		char choice = '1';
		
		do {
			
			displayMenu();
			
			inputLine = input.nextLine();
			choice = inputLine.charAt(0);
			
			switch(choice) {
				case '1':{
					searchProduct(input,products,inputLine);
					break;
				}
				case '2': {
					addProduct(input,products,inputLine);
					break;
				}
				case '3': {
					printProducts(products);
					break;
				}
				case '4': {
					System.out.println("Exiting...");
				}
			}
			
			
		}while(choice != '4');
		
	}
	
	public static void displayMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Search a product");
		System.out.println("2. Add a product");
		System.out.println("3. Print all products");
		System.out.println("4. Exit");
	}
	
	public static void addProduct(Scanner input, HashSet<String> products, String inputLine) {
		
		boolean isAdded = false;
		
		do {
			System.out.println("Enter a Product to Add: ");
			inputLine = input.nextLine();
			
			//check if exists
			if(checkContains(products, inputLine)) {
				System.out.println("Products exists please input another");
			}
			else {
				products.add(inputLine);
				System.out.println("Product added: " + inputLine);
				isAdded = true;
			}
			
			
		}while(isAdded == false);
			
	}
	
	public static void searchProduct(Scanner input, HashSet<String> products, String searchString) {
		
		System.out.println("Enter a product to search:");
		
		searchString = input.nextLine();
		
		if (checkContains(products,searchString)) {
			System.out.println("Product found!");
		}
		else {
			System.out.println("Product not found!");
		}
		
	}
	
	public static boolean checkContains(HashSet<String> products, String searchString) {
		return products.contains(searchString);
	}
	
	public static void printProducts(HashSet<String> products) {
		
		System.out.println("All products:");
		
		for (String i : products) {
			System.out.println(i);
		}
		
	}
}
