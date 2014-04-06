// solution took 259 ms

import java.util.*;

public class Problem22{

	//Capital A is 65 in ascii
	public static final int ASCII_OFFSET = 64;
	
	public static void main (String[] args) {
		//Start timer
		long tik = System.nanoTime();
		
		//Get name list
		ArrayList<String> names = getNames();
  		
  		long sum = 0;
  		int cnt = 1;
  		
  		//Calculate total score
  		// namevalue*pos = score
  		for(String name : names) {
  			sum += getNameValue(name.toCharArray()) * cnt++; //inc count
  		}
		
		
		//Ans
		System.out.println(sum);
		
		//Stop Timer
		long tok = System.nanoTime();
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
	
	//Fetches names from standard input using regex
	public static ArrayList<String> getNames() {
	
		//input stored in following format:
		// "name","name2",...
		Scanner in = new Scanner(System.in).useDelimiter("[\",]+");
		ArrayList<String> names = new ArrayList<String>();
  		
  		//read names
  		while (in.hasNext()) {
    		names.add(in.next());
  		}
  		
  		//sort
  		Collections.sort(names);
  		return names;
	}
	
	//Calculates a names value
	public static int getNameValue(char[] name) {
		int sum = 0;
		for(int i = 0; i < name.length; i++){
			sum += (int)name[i] - ASCII_OFFSET;
		}
		return sum;
	}
	
}