package m2.activity6;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car vehicle1 = new Car(4, "Toyota");
		Truck vehicle2 = new Truck(4, "Ford");
		
		System.out.println(vehicle1.getBrand());
		System.out.println(vehicle1.getNumberOfWheels());
		vehicle1.refuel();
		destroyVehicle(vehicle1);
		
		System.out.println(vehicle2.getBrand());
		System.out.println(vehicle2.getNumberOfWheels());
		vehicle2.refuel();
		destroyVehicle(vehicle2);
		
	}
	
	public static void destroyVehicle(Vehicle vehicle) {
		vehicle.destroy();
	}

}
