//167 ms
//Same solution as Problem 18
import java.util.*;

public class Problem67 {
	
	public static void main(String[] args) {
		long tik = System.nanoTime();
		
		Scanner in = new Scanner(System.in);
		
		int length = in.nextInt(); //100
		int[][] data = new int[length][length];
		
		for(int i = 1; i <=length; i++) {
			for(int j = 0; j < i; j++) {
				data[i - 1][j] = in.nextInt();
			}
		}
		
		//Bubble the max child upwards
		//   1     =    5
		//  3 4
		for(int r = length - 1; r >0; r--)
			for(int c = r; c >0; c--)
				data[r-1][c-1] += Math.max(data[r][c], data[r][c-1]);
		
		long tok = System.nanoTime();
		System.out.println(data[0][0]); //our answer will be in the top
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
}