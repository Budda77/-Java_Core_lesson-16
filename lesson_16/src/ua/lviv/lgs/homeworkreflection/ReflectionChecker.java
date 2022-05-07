package ua.lviv.lgs.homeworkreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import ua.lviv.lgs.Person;

public class ReflectionChecker {
	
	Car newInstanceCar;
	public void showClassName(Object object) {
		Class carClass = object.getClass();
		System.out.println("Full name:    " + carClass.getName());
		System.out.println("Simple name:  " + carClass.getSimpleName());
	}
	
	public void showClassProject(Object object) {
		Class carClass = object.getClass();
		Package classPackage = carClass.getPackage();
		System.out.println(classPackage);
	}
	
	public void showClassModifier(Object object) {
		Class carClass = object.getClass();
		int modifier = carClass.getModifiers();
		String modifierText = Modifier.toString(modifier);
		
		System.out.println("Class modifier = " + modifierText);
		System.out.println("is static = " + Modifier.isStatic(modifier));
		System.out.println("is public = " + Modifier.isPublic(modifier));
		System.out.println("is abstract = " + Modifier.isAbstract(modifier));
		}
	
	public void showClassConstructor(Object object) {
		Class carClass = object.getClass();
		Constructor[] constructors = carClass.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println("Constructor:  " + constructor.toString());
			System.out.println("Parameter Constructor:  " + constructor.getParameterCount());
		}
	}	
		
	public void showAllFields(Object object) {
		Class carClass = object.getClass();
		Field [] fields = carClass.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
	
	public void showClassMethods(Object object) {
		Class carClass = object.getClass();
		Method [] methods = carClass.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
	
	public void showAllMethods(Object object) {
		Class carClass = object.getClass();
		Method[] declaredMethods = carClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
		    System.out.println(method);
		}
	}
	
	public void showPrivateMethod(Object object, String method, Class<?>[] parameter) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<? extends Object> carClass = object.getClass();
		try {
			Method privateMethods = carClass.getDeclaredMethod(method, parameter);   //String.class, int.class
			System.out.println(privateMethods);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	// The method that install the single constructor parameters
	public Constructor<?> instCar(Object object) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> carClass = object.getClass();
		Constructor<?>singleConstructor = carClass.getConstructor(int.class, int.class, String.class, String.class);
		return singleConstructor;
	}
	
	public void setConstructor(Object object) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inpur horsepower: ");
		int power = sc.nextInt();
		System.out.println("Inpur release of year: ");
		int release = sc.nextInt();
		System.out.println("Inpur serial number: ");
		String plate = sc.next();
		System.out.println("Inpur car model: ");
		String model = sc.next();
		
		//Car newCar = singleConstructor.newInstance(power, release, plate, model);
		newInstanceCar = (Car) instCar(object).newInstance(power, release, plate, model); 
		System.out.println("Reflection new Car:  " +  newInstanceCar);		
	}
	public void showNewInstance() {
		System.out.println("Reflection new Car object:  " +  newInstanceCar);
	}
	
	public void setConstructorData(Object object) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {		
		newInstanceCar = (Car) instCar(object).newInstance(2, 2022, "751-315", "BMW"); //(Car)carClass.getConstructor(params).newInstance(2, 2021, "79-07", "BMV");
		System.out.println("Reflection the Car:  " +  newInstanceCar);
	}
	
//	public Car installationCar(Object object) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		Class<?> carClass = object.getClass();
//		Constructor<?>singleConstructor = carClass.getConstructor(int.class, int.class, String.class, String.class);
//		Car newInstanceCar = (Car) singleConstructor.newInstance(2, 2022, "75-75", "BMW");	
//		return newInstanceCar;
//	}
		
	// The second option to set parameters in constructor
	public void setConstructorData2(Object object) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> carClass = object.getClass();
		Class[]params = {int.class, int.class, String.class, String.class};
		Car newInstanceCar = (Car)carClass.getConstructor(params).newInstance(1, 1979, "79-07", "Opel");
		System.out.println("Reflection new Car:  " +  newInstanceCar);
	}
	
	public void setClassField(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		System.out.println("Set the value of fields: car model and year of release: ");
		
		Class carClass = object.getClass();
		Field carModel = carClass.getField("model");
		Field yearOfRelease = carClass.getDeclaredField("release");
		
		yearOfRelease.setAccessible(true);
		System.out.println("Car model Before change:       " + carModel.get(newInstanceCar));
		System.out.println("Year of release Before change: " + yearOfRelease.get(newInstanceCar)); 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Inpur car model: ");
		String model = sc.next();
		System.out.println("Inpur release of year: ");
		int release = sc.nextInt();
		
		carModel.set(newInstanceCar, model);
		
		yearOfRelease.setInt(newInstanceCar, release);
		
		System.out.println("Car model After change:       " + carModel.get(newInstanceCar));
		System.out.println("Year of release After change: " + yearOfRelease.get(newInstanceCar));
	}
	
}
