package ua.lviv.lgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;



public class Application {

	public static <Field, Method> void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class ps = Person.class; 
		Person person = new Person();
		
		//get name of class
		String nameOfClass = ps.getName();
		System.out.println("Name of class = " + nameOfClass);
		
		String simpleName = ps.getSimpleName();
		System.out.println("Simple Name = " + simpleName);
		
		//get Modifier
		int modifier = ps.getModifiers();
		String modifierText = Modifier.toString(modifier);
		
		System.out.println("Class modifier = " + modifierText + " int " +  modifier);
		System.out.println("is static = " + Modifier.isStatic(modifier));
		System.out.println("is public = " + Modifier.isPublic(modifier));
		System.out.println("is abstract = " + Modifier.isAbstract(modifier));
		
		//package info
		Package classPackage = ps.getPackage();
		System.out.println("Package of this class " + classPackage);
		
		// get super class
		Class superClass = ps.getSuperclass();
		System.out.println("Super class " +superClass);
		
		//get interfaces
		Class[] interfaces = ps.getInterfaces();
		System.out.println("Interfaces " +Arrays.toString(interfaces));
		
		//getConstructor
		System.out.println("Get constructor:");
		Constructor<Person>[] personConstructor = ps.getConstructors();
		for (int i = 0; i < personConstructor.length; i++) {
			Constructor<Person> constructor = personConstructor[i];
			System.out.println("Constructor -  "+ constructor);
		}
		
		System.out.println("Constructor size "+personConstructor.length);
		
		//get parameters of constructor
		System.out.println("Get constructor parameters:");
		Constructor<Person> constructor = personConstructor[02];
		Class<?>[] parameterType = constructor.getParameterTypes();
		for (int i = 0; i < parameterType.length; i++) {
			Class<?> class1 = parameterType[i];
			System.out.println(class1);
		}
		
		//get Constructor by parameter
		Person newInstancePerson = extracted(person);
		
		System.out.println("\nReflection Person_II  : "+ newInstancePerson);

		/*
		Constructor<Person> singleConstructor = ps.getConstructor(String.class, int.class);
		System.out.println("\nSingle Constructor " +singleConstructor);	
		Person newInstancePerson = singleConstructor.newInstance("Petro", 22);
		System.out.println("\nReflection Person: "+ newInstancePerson);	
*/		
		
		System.out.println("\nGet Field ");
		
		//get Fields
		java.lang.reflect.Field[] fields = ps.getFields();
		
	for (int i = 0; i < fields.length; i++) {
		java.lang.reflect.Field field = fields[i];
		System.out.println(field);
	}
	

	System.out.println("\nGet all fields :");
	//get Fields
	fields = ps.getDeclaredFields();

	for (int i = 0; i < fields.length; i++) {
		java.lang.reflect.Field field = fields[i];
		System.out.println("-     " + field);
	}

		//field set
	System.out.println("\nSet field");
	java.lang.reflect.Field ageField = ps.getField("age");
	
	ageField.set(newInstancePerson, 100);
	
	System.out.println("new age " + newInstancePerson);
	
	
	java.lang.reflect.Field privateLastNameField = fields[3];
	
	privateLastNameField.setAccessible(true);
	System.out.println("private value " + privateLastNameField.get(newInstancePerson));
	
	// Methods
	System.out.println("\n get Methods:");
	
	java.lang.reflect.Method[] methods = ps.getMethods();
	for (int i = 0; i < methods.length; i++) {
		java.lang.reflect.Method method = methods[i];
		System.out.println(method);
	}
	
	methods[4].invoke(newInstancePerson, "Tina");
	System.out.println();
	System.out.println(newInstancePerson);
	
	
	
	}

	private static Person extracted(Person person) throws NoSuchMethodException, SecurityException, InstantiationException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class ps = person.getClass() ;
		Constructor<Person> singleConstructor = ps.getConstructor(String.class, int.class);

		Person newInstancePerson = singleConstructor.newInstance("Petro", 22);
		
		return newInstancePerson;
	}

}
