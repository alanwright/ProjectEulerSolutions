// solution took 16 ms

import java.util.*;

class Problem20
{
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//Start timer
		long tik = System.nanoTime();
		
		//Calculate 100!
		ArrayList<Integer> bigNum = fact(100);
		
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
	
	//Calculates num factorial and returns the answer in a list of ints
	public static ArrayList<Integer> fact(int num){
		
		//Multiply our current total by each number from [2 - num]
		ArrayList<Integer> total = new ArrayList<Integer>();
		total.add(1);
		for(int i = 2; i <= num; i++){
			total = mult(total, convert(i));
		}
		return total;
	}
	
	//Multiply two list numbers
	public static ArrayList<Integer> mult(ArrayList<Integer> num1, ArrayList<Integer> num2){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		//Num2 will be our bottom multiplier
		int count = 0;
		for(int i = num2.size() - 1; i >= 0; i--){
			
			//Temp variables
			// NOTE: currDigit is keeping track of how many digits we 
			// have multiplied (i.e. when you multiply with the 7 in 176
			// you place a 0 in the first multiplication digit.
			int temp = 0, currDigit = ans.size() - count - 1, carry = 0;
			
			//Multiply our digit in num2 by all digits in num1
			for(int j = num1.size() - 1; j >= 0; j--){
				
				//Multiplication + carry
				temp = num2.get(i) * num1.get(j) + carry;
				
				//Check for new carry
				if(temp > 9){
					carry = temp / 10;
					temp %= 10;
				}
				else {
					carry = 0;
				}
				
				//Check if we need to add digits to the front of our number
				if(i == num2.size() - 1 || currDigit < 0)
					ans.add(0, temp);
				
				//If not, lets update the appropriate digit place using currDigit :)
				// NOTE: no sense in worrying about overflow in the answer (i.e. a 
				//  multiple digit number in a spot; we can handle this all at once)
				else {
					temp += ans.get(currDigit);
					ans.set(currDigit, temp);
					currDigit--;
				}
			}
			count++;
			
			//Check for any extra carry
			if(carry != 0)
				ans.add(0, carry);
		}
		
		//Loop through the answer and split each digit into a single digit 
		// and carry over the extra
		for(int i = ans.size() - 1; i >= 0; i--){
			
			int temp = ans.get(i).intValue();
			
			//If we have a mult. digit
			if(temp > 9) {
				
				//Check for in the front of answer; we need to add new digits
				if(i == 0){
					
					//Loop until we get a single digit
					int tempCount = 1;
					while(temp > 9) {
						
						//Add a new digit
						ans.add(0, temp / 10);
						
						//Since we added a new digit, our original i is i + count
						ans.set(i + tempCount, temp % 10); 
						
						//Move our decimal
						temp /= 10;
					}
				}
				
				//Otherwise we can factor normally
				//NOTE it is possible that we would need to loop similiar to above,
				// but for our 100! purposes, it's not needed
				else {
					ans.set(i-1, ans.get(i-1) + temp / 10);
					ans.set(i, temp % 10);
				}
			}
		}
		
		return ans;
	}
	
	//Converts an integer into a list of integers.
	public static ArrayList<Integer> convert(int num) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int temp = num;
		while(temp != 0){
			ans.add(0, temp % 10);
			temp /= 10;
		}
		return ans;
	}
	
	//Prints a list as a number. Used for debugging.
	public static void printList(ArrayList<Integer> num){
		for(Integer i : num)
			System.out.print(i);
		System.out.println();
	}
	
}