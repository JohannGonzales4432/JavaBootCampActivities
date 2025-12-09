package m2.activity6;

public abstract class Vehicle {
	
	private int numberOfWheels;
	private String brand;
	
	public Vehicle(){
		
	}
	
	public Vehicle(int numberOfWheels, String brand) {
		this.setNumberOfWheels(numberOfWheels);
		this.setBrand(brand);
	}
	
	abstract void startEngine();
	
	public void destroy() {
		System.out.println("This " + this.brand + " with " + this.numberOfWheels + " wheels will now be destroyed");
	}
	
	
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	public int getNumberOfWheels() {
		return this.numberOfWheels;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
}
