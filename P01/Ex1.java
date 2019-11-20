package P01;

import java.util.*;

public class Ex1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double num1 = 0, num2 = 0, total = 0;
		String operador = null;
		
		System.out.println("Insira a conta:");
		
		if(input.hasNextDouble())
			num1 = input.nextDouble();
		else {
			System.err.println("Operando inválido");
			System.exit(0);
		}
		if(input.hasNext())
			operador = input.next();
		else {
			System.err.println("Operador inválido");
			System.exit(0);
		}
		if(input.hasNextDouble())
			num2 = input.nextDouble();
		else {
			System.err.println("Operando inválido");
			System.exit(0);
		}
		
		input.close();
		
		switch(operador) {
			case "+":
				total = num1 + num2;
				break;
			case "-":
				total = num1 - num2;
				break;
			case "*":
				total = num1 * num2;
				break;
			case "/":
				total = num1 / num2;
				break;
			default:
				System.err.println("Operador inválido");
				System.exit(0);
		}
		
		System.out.println("Total: " + total);
	}

}
