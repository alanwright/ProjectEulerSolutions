// solution took 535 ms

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Problem14
{
		public final static int MAX_NUM = 1000000;
	public static int[] storedSteps = new int[MAX_NUM];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//Start timer
		long tik = System.nanoTime();
		
		//int maxNum = bruteForce();
		int maxNum = dpSolution();
		
		System.out.println(maxNum);
			
		long tok = System.nanoTime();
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
	
	public static int dpSolution() {
		int maxSteps = 0, maxNum = MAX_NUM - 1;
		for(int i = 2; i < MAX_NUM - 1; i++){
			long num = i;
			int steps = 0;
			while(num != 1) {
				if(storedSteps[i] != 0) {
					steps += storedSteps[i];
					break;
				}
				
				if(num % 2 == 0)
					num /= 2;
				else
					num = 3 * num + 1;
				steps++;
			}
			storedSteps[i] = steps;
			
			if(steps > maxSteps) {
				maxSteps = steps;
				maxNum = i;
			}
		}
		return maxNum;
	}
	
	public static int bruteForce() {
	
		int maxSteps = 0, maxNum = MAX_NUM - 1;
		for(int i = MAX_NUM - 1; i >10; i--){
			long num = i;
			int steps = 0;
			while(num != 1) {
				if(num % 2 == 0)
					num /= 2;
				else
					num = 3 * num + 1;
				steps++;
			}
			if(steps > maxSteps) {
				maxSteps = steps;
				maxNum = i;
			}
		}
		return maxNum;
	}
}