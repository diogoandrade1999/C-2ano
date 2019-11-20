package P01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex6_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, String> lib = new HashMap<>();

		Scanner input = new Scanner(new FileReader("dic2.txt"));
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String[] s = line.split("\\s+");
			String key = s[0];
			String value = s[1];
            
			for(int i = 2; i < s.length; i++)
				   value += " " + s[i];
            
            lib.put(key, value);
            }
		
		input.close();
		
		input = new Scanner(System.in);
		
		System.out.print("Texto: ");
		
		String line = input.nextLine();
		
		System.out.print("Text:");
		
		for(String s : line.split("\\s+")) {
			if(lib.containsKey(s))
				System.out.print(" " + lib.get(s));
			else
				System.out.print(" " + s);
		}
		
		input.close();

	}

}
