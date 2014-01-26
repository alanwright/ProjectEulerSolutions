//Solution took 711 ms
import java.util.*;

public class Euler {
	
	public static void main(String[] args) {
		long tik = System.nanoTime();
		
		int currNum = 0;
		int i = 1;
		while(numDivisors(currNum) < 500){
			currNum+=i;
			i++;
		}
		
		long tok = System.nanoTime();
		System.out.println(currNum);
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
	
	public static int numDivisors(int num){
		int divisors = 0;
		int sqrt = (int) Math.sqrt(num);
		
		//Find all divisors, except square root
		for(int i = 1; i < sqrt; i++){
			if(num % i == 0)
				divisors+=2;
		}
		
		//If the number is a perfect square, add a divisor
		if(sqrt*sqrt == num)
			divisors++;
		
		return divisors;
	}

}
