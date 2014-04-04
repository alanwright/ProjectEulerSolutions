//69 ms
import java.util.*;

public class Problem17 {
	
	public static void main(String[] args) {
		long tik = System.nanoTime();
		
		Scanner in = new Scanner(System.in);
		int sum = 0;
		while(true) {
			String word = in.next();
			int num = in.nextInt();
			if(num == 0) break;
			sum += word.length() * num;
		}
		long tok = System.nanoTime();
		System.out.println(sum);
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
}