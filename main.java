package m3.activity1;
import java.util.Scanner;
import java.util.ArrayList;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String inputLine;
		
		
		list.add("Laptop");
		list.add("Mouse");
		list.add("Keyboard");
		list.add("Monitor");
		list.add("Printer");
		
		
		System.out.println("All products");
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		System.out.println("All products after update");
		
		list.add("Webcam");
		list.remove("Mouse");
		
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("Enter product name:");
		inputLine = input.nextLine();
		
		System.out.println("Exists (using .contains()): " + list.contains(inputLine));
		
		for (int i = 0 ; i < list.size() ; i++) {
			if(list.get(i) == inputLine) {
				System.out.println("Found using for loop");
			}
		}
		
		
	}

}
