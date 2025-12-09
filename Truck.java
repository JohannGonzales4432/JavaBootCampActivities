package m2.activity6;

public class Truck extends Vehicle implements Refuelable {
	
	public Truck() {
		
	}
	
	public Truck(int numberOfWheels, String brand) {
		this.setBrand(brand);
		this.setNumberOfWheels(numberOfWheels);
		
	}
	
	@Override
	public void startEngine() {
		System.out.println("The Truck has started its engine");
	}
	
	@Override
	public void refuel() {
		System.out.println("The Truck is refueling");
	}
}
