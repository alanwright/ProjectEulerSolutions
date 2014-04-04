//solution took 0 ms :)

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Problem13
{
	public final static int NUM_STRINGS = 100;
	public final static int STRING_LENGTH = 50;
	
	public static void main (String[] args) throws java.lang.Exception
	{

		Scanner in = new Scanner(System.in);
		String[] nums = new String[NUM_STRINGS];
		int[] sums = new int[STRING_LENGTH];
		
		//Scan in numbers
		for(int i = 0; i < NUM_STRINGS; i++) {
			nums[i] = in.next();
			
			//Calculate the sums at each index [0-49] 0 being the leftmost digit
			for(int j = 0; j < STRING_LENGTH; j++) {
				sums[j] += Character.getNumericValue(nums[i].charAt(j));
			}
		}
		
		//Start timer
		long tik = System.nanoTime();
		
		long finalSum = 0;
		long carry = 0;
		
		//Loop right to left, we just want a close estimate
		for(int i = STRING_LENGTH - 1; i >= 0; i--) {
			
			//If we're in our last 10 digits, multiply the sum by 10^digit and add to our total
			if(i < 10){
				finalSum += sums[i] * (Math.pow(10, (8 - i)));
			}
			
			//If we're not in our last 10 digits, we're calculating a carry
			else {
				//Add the last digit from our carry since it carried over
				//	Now the last digit won't carry, so /10 to cut if off. Add to carry
				carry += (sums[i] + carry % 10) / 10;
				
				//Now that we've added the last digit from carry, we can cut if off
				// Don't do this on our first loop
				if(i != STRING_LENGTH - 1)
					carry /= 10;
				
				//Put our carry in the final sum
				if(i == 10)
					finalSum = carry;
			}
		}
		System.out.println(finalSum);
			
		long tok = System.nanoTime();
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
}