//0 ms
import java.util.*;

public class Problem28 {
	
	public static final int SIZE = 1001*1001;
	
	public static void main(String[] args) {
		long tik = System.nanoTime();

		int sum = 1;
		int incVal = 2; 		//increments by 2 for each spiral
		int cnt = 0; 			//tells us when we hit the end of a spiral
		for(int i = 3; i <= SIZE; i+=incVal) {
			cnt++;
			sum+=i;

			//We hit all 4 corners of a spiral
			if(cnt == 4) {
				cnt = 0;
				incVal += 2; 	//start new spiral
			}
		}

		long tok = System.nanoTime();
		System.out.println(sum);
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
}