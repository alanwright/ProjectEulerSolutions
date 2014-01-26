// solution took 31 ms

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Problem16
{
	public final static int MAX_NUM = 1000000;
	public static int[] storedSteps = new int[MAX_NUM];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//Start timer
		long tik = System.nanoTime();
		
		//Calculate 2^1000
		ArrayList<Integer> bigNum = listPow(2, 1000);
		
		//Sum digits
		int sum = 0;
		for(Integer i : bigNum)
			sum+=i.intValue();
		
		//Ans
		System.out.println(sum);
		
		//Stop Timer
		long tok = System.nanoTime();
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
	
	//Calculates base to the power and returns the answer as a list of ints
	public static ArrayList<Integer> listPow(int base, int power){
		
		//Convert base to ArrayList
		ArrayList<Integer> baseList = new ArrayList<Integer>();
		int temp = base;
		while(temp != 0){
			baseList.add(0, temp % 10);
			temp /= 10;
		}
		
		//Add sum to itself, power number of times. This simulates multiplication by 2
		ArrayList<Integer> sum = baseList;
		for(int i = 1; i < power; i++){
			sum = listSum(sum, sum);
		}
		return sum;
	}
	
	//Sums 2 lists
	public static ArrayList<Integer> listSum(ArrayList<Integer> num1, ArrayList<Integer> num2){
		ArrayList<Integer> sum = new ArrayList<Integer>();
		
		//Find longer number
		int length;
		if(num1.size() > num2.size())
			length = num1.size();
		else
			length = num2.size();
		
		//Add digits
		int carry = 0;
		for(int i = length - 1; i >= 0; i--){
			
			//Temp variables
			int int1 = 0, int2 = 0, tempSum = 0;
			
			//check if we're in bounds
			if(i < num1.size())
				int1 = num1.get(i);
			if(i < num2.size())
				int2 = num2.get(i);
			
			//Create sum of this digit
			tempSum = int1 + int2 + carry;
			
			//check for carry
			if(tempSum > 9) {
				tempSum -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			
			//Add our new digit
			sum.add(0, tempSum);
		}
		
		//Check for extra carry
		if(carry == 1)
			sum.add(0, 1);
		
		return sum;
	}
	
	//Prints a list as a number. Used for debugging.
	public static void printList(ArrayList<Integer> num){
		for(Integer i : num)
			System.out.print(i);
		System.out.println();
	}
	
}