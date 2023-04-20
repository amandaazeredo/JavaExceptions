package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stack_trace {

	public static void main(String[] args) {

		method1();
		
		System.out.println("End of program");

	}
	
	public static void method1() {

	System.out.println("Method1 started:");
	method2();
	System.out.println("Method1 ended.");
	
	}
	public static void method2() {
		
		System.out.println("Method2 started:");
		Scanner sc = new Scanner(System.in);

		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position");
			//informa com detalhes a chamada de métodos que fez com que a exceção ocorresse.
			e.printStackTrace();
			sc.next();
		}

		catch(InputMismatchException e) {
			System.out.println("Input error");
			//informa com detalhes a chamada de métodos que fez com que a exceção ocorresse.
			e.printStackTrace();
			sc.next();
		}

		sc.close();
		
		System.out.println("Method2 ended.");
	}
}