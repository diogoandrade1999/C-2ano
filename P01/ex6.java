package P01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, String> lib = new HashMap<>();

		Scanner input = new Scanner(new FileReader("dic1.txt"));
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String value = null;
			String key = null;
			
            for (String s : line.split("\\s+")) {
        	   if(key == null)
        		   key = s;
        	   else
        		   value = s;
            
            lib.put(key, value);
            }
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
