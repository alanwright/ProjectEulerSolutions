//1047 ms
import java.util.*;

public class Problem30 {
	
	// We want x * 9^5 to be x digits...
	// 1 through 5 don't work...
	// 6 * 9^5 makes a 6 digit number, so we'll use it as our upper bound
	public static final int SIZE = 6 * (int)Math.pow(9, 5); 
	
	public static void main(String[] args) {
		long tik = System.nanoTime();


		int finalSum = 0;
		for(int i = 2; i <= SIZE; i++) {
			int num = i;
			int sum = 0;

			//Isolate each digit
			while(num > 0){
				int digit = num % 10;
				num = num/10;

				sum += Math.pow(digit, 5);
			}

			//Add to sum if we find a match
			if(sum == i)
				finalSum+=i;
		}

		long tok = System.nanoTime();
		System.out.println(finalSum);
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
}