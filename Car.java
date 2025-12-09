package m2.activity6;

public class Car extends Vehicle implements Refuelable{
	public Car() {
		
	}
	
	public Car(int numberOfWheels, String brand) {
		this.setBrand(brand);
		this.setNumberOfWheels(numberOfWheels);
		
	}
	
	@Override
	public void startEngine() {
		System.out.println("The Car has started its engine");
	}
	
	@Override
	public void refuel() {
		System.out.println("The Car is refueling");
	}
}
