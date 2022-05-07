/*
 * LOGOS It Academy home work 15
 * 
 * */

package ua.lviv.lgs.homeworkreflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * This program demonstrates the use of Reflection.
 * @author Oleksandr
 * @param input parameters is String and int.
 * 
 */
public class MainReflection {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		ReflectionChecker checker = new ReflectionChecker();
		Car car = new Car();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nDisplay menu, press 1");
			switch(scanner.nextInt()) {
			
			case 1:{
				menu();					
				break;
			}
			case 2:{
				// reflects class
				System.out.println("Name of the class: ");
				checker.showClassName(car);
				break;
			}
			case 3:{
				// reflects package
				System.out.println("Name of package: ");
				checker.showClassProject(car);
				break;
			}
			case 4:{
				// reflects Modifier
				System.out.println("Modifier: ");
				checker.showClassModifier(car);
				break;
			}
			case 5:{
				// reflects constructors
				System.out.println("Constructors: ");
				checker.showClassConstructor(car);
				break;
			}
			case 6:{
				// reflects all fields
				System.out.println("Fields: ");
				checker.showAllFields(car);
				break;
			}
			case 7:{
				// reflects only public methods
				System.out.println("Reflects public methods:");
				checker.showClassMethods(car);
				break;
			}
			case 8:{
				// method reflect all methods including private
				System.out.println("Reflects all methods:");
				checker.showAllMethods(car);
				break;
			}
			case 9:{
				// reflect only private methods
				System.out.println("Reflects only private method:");
				String method = "myMethod";
				Class<?>[] parameterTypes = {String.class, int.class};
				try {
					checker.showPrivateMethod(car, method, parameterTypes);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				break;
			}
			case 10:{
				System.out.println("Instollation of initial constructor:\n");
				checker.setConstructorData(car);
				break;
			}
			case 11:{
				//set constructor manually
				System.out.println("Set parameters of object:");
				checker.setConstructor(car);
				break;
			}
			case 12:{
				//set fields manually
				System.out.println("Set fields:");
				checker.setClassField(car);
				break;
			}
			case 13:{
				System.exit(0);	
				break;
			}
			default:{
				System.out.println("Enter the number from 1 to 13");
			}
			
			}	
		}		
	}

	static void menu() {
		System.out.println("Enter 2 to get Name of the class");
		System.out.println("Enter 3 to get Package of the class");
		System.out.println("Enter 4 to get Modifier of the class");
		System.out.println("Enter 5 to get Constructors of the class");
		System.out.println("Enter 6 to get Fields of the class");
		System.out.println("Enter 7 to get public methods of the class");
		System.out.println("Enter 8 to get all methods of the class");
		System.out.println("Enter 9 to get private methods of the class");	
		System.out.println("Enter 10 to Default constructor parameters");
		System.out.println("Enter 11 to set constructor parameters manually");
		System.out.println("Enter 12 to set fields parameters manually");
		System.out.println("Enter 13 to log out the program");
	}
}
