//82 ms
import java.util.*;
import java.math.BigInteger;

public class Problem25 {
	
	public static void main(String[] args) {
		long tik = System.nanoTime();
		
		BigInteger ROOF = new BigInteger("10");
		ROOF = ROOF.pow(999);
		
		int count = 3;
		BigInteger past = new BigInteger("1");
		BigInteger curr = new BigInteger("2");
		while(curr.compareTo(ROOF) <= 0) {
			BigInteger temp = curr;
			curr = past.add(curr);
			past = temp;
			count++;
		}
		
		long tok = System.nanoTime();
		System.out.println(count);
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
}