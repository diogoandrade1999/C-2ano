package P01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<String, Double> lib = new HashMap<>();

		System.out.println("Insira a conta:");

		while(input.hasNextLine()) {
			String line = input.nextLine();
			String[] s = line.split("\\s+");
			
			if(s.length == 1) {
				System.out.println(lib.get(s[0]));
			}else if(s[1].equals("=")) {
				if(s.length == 3) {
					if(lib.containsKey(s[0])) {
						lib.replace(s[0], isId(s[2], lib));
					}else {
						lib.put(s[0], isId(s[2], lib));
					}
				}else if(s.length == 5) {
					if(lib.containsKey(s[0])) {
						lib.replace(s[0], count(s[3], isId(s[2], lib), isId(s[4], lib)));
					}else {
						lib.put(s[0], count(s[3], isId(s[2], lib), isId(s[4], lib)));
					}
				}
				System.out.println(lib.get(s[0]));
			}else {
				System.out.println(count(s[1], isId(s[0], lib), isId(s[2], lib)));
			}
			//System.out.println(lib.toString());
		}
		input.close();
	}

	public static double count(String s, double d1, double d2) {
		if(s.equals("+")) {
			return d1 + d2;
		} else if(s.equals("-")) {
			return d1 - d2;
		} else if(s.equals("*")) {
			return d1 * d2;
		} else if(s.equals("/")) {
			return d1 / d2;
		}else {
			System.err.println("Operador inválido");
			System.exit(0);
		}
		return 0;
	}

	public static double isId(String s, Map<String, Double> lib) {
		Double num = null;
		try {
			num = Double.parseDouble(s);
		} catch(Exception e) {
			if(!lib.containsKey(s)) {
				System.err.println("Varável não existente!");
				System.exit(0);
			}else if(lib.containsKey(s)) {
				num = lib.get(s);
			}else {
				if(Character.isDigit(s.charAt(0))) {
					System.err.println("Varável não válida!");
					System.exit(0);
				} else {
					String snull = null;
					
					for(char c : s.toCharArray()) {
						if(Character.isAlphabetic(c))
							snull += c;
						if(Character.isDigit(c))
							snull += c;
						if(c == '_')
							snull += c;
					}
					
					if(!snull.equals(s)) {
						System.err.println("Varável não válida!");
						System.exit(0);
					}
						
				}
			}
		}
		return num;
	}
}
