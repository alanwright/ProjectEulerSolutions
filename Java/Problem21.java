//4 ms
import java.util.*;

public class Problem21 {
	
	public static void main(String[] args) {
		long tik = System.nanoTime();
		
		int ROOF = 10001;
		int[] factSums = new int[ROOF];
		
		//sieve type summing
		for(int i = 2; i <= ROOF; i++) 
        	for(int j = i*2; j < ROOF; j+=i)
        		if(factSums[j] + i < ROOF) //don't go out of bounds later 
        			factSums[j] += i;
        	
        int sum = 0;
        
        //find Amicable pairs
        for(int i = 2; i < ROOF; i++) {
        	int j = factSums[i] + 1;
        	if(i < j && factSums[j] + 1 == i) 
        		sum += i + j;
        }
			
		long tok = System.nanoTime();
		System.out.println(sum);
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
}