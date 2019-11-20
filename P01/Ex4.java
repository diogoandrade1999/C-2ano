package P01;

import java.io.*;
import java.util.*;

public class Ex4 {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> lib = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
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
		
		for(String s : line.split("[ -]")) {
			if(!s.equals(" "))
				list.add(lib.get(s));
		}
		
		input.close();
		
		for(int i = 0; i < list.size()-1; i++) {
			int var1 = list.get(i);
			int var2 = list.get(i+1);
			if(var1 < var2) {
				list.set(i, var1*var2);
				list.remove(i+1);
				i--;
			}
		}
		
		int count = list.size();
		while(count-1 > 0) {
			int var1 = list.get(0);
			int var2 = list.get(1);
			list.set(0, var1+var2);
			list.remove(1);
			count--;
		}

		System.out.println("Number: " + list.get(0));
	}

}
