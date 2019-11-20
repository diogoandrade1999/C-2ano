package P01;

import java.io.*;
import java.util.*;

public class Ex3 {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> lib = new HashMap<>();
		
		Scanner input = new Scanner(new FileReader("numbers.txt"));
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			int value = -1;
			String key = null;
			
            for (String s : line.split("[ -]")) {
               if(!s.equals(" ")) {
            	   if(value == -1)
            		   value = Integer.parseInt(s);
            	   else
            		   key = s;
               }
            
            lib.put(key, value);
            }
		}
		
		input.close();
		
		input = new Scanner(System.in);
		
		System.out.print("A list of numbers: ");
		
		String line = input.nextLine();
		
		System.out.print("A list of numbers:");
		
		for(String s : line.split("[ -]")) {
			if(!s.equals(" "))
				System.out.print(" " + lib.get(s));
		}
		
		input.close();
	}

}
