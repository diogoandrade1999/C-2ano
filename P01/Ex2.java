package P01;

import java.util.*;

public class Ex2 {

	public static void main(String[] args) {
		Stack<Double> pilha = new Stack<>();

		Scanner input = new Scanner(System.in);
		double num1 = 0, num2 = 0, total = 0;
		String operador = null;
		
		System.out.println("Insira:");
		
		while(true) {
			if(input.hasNextDouble()) {
				double num = input.nextDouble();
				pilha.push(num);
				System.out.println("Stack: " + pilha);
			}else if(input.hasNext()) {
				operador = input.next();
				
				if(!pilha.isEmpty())
					num1 = pilha.pop();
				else {
					input.close();
					System.err.println("Não exite Operandos!");
					System.exit(0);
				}
				if(!pilha.isEmpty())
					num2 = pilha.pop();
				else {
					input.close();
					System.err.println("Não exite Operandos sufecientes para fazer a opração!");
					System.exit(0);
				}
				
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
						input.close();
						System.err.println("Operador inválido");
						System.exit(0);
				}
				pilha.push(total);
				System.out.println("Stack: " + pilha);
			}else {
				input.close();
				System.exit(0);
			}
		}
	}

}
