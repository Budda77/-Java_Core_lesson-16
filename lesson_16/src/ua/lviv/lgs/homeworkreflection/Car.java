package ua.lviv.lgs.homeworkreflection;

public class Car {
	
    private int horsepower;
    private int release;
    public String serialNumber;
    public String model;
    
	public Car() {
		super();
	}
	
	public Car(String model, int release) {
		this.model = model;
		this.release = release;
	}

	public Car(int horsepower, int release, String serialNumber, String model) {
		super();
		this.horsepower = horsepower;
		this.serialNumber = serialNumber;
		this.model = model;
		this.release = release;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	
	public int getRelease() {
		return release;
	}

	public void setRelease(int release) {
		this.release = release;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horsepower;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + release;
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (horsepower != other.horsepower)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (release != other.release)
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		return true;
	}
	
	private void myMethod(String s, int numbers) {							
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(s + numbers[i]);
//		}
//		System.out.println(numbers.length);
	}
	
	@Override
	public String toString() {
		return "Car [horsepower=" + horsepower + ", release=" + release + ", serialNumber=" + serialNumber + ", model="
				+ model + "]";
	}
	 
	

}
