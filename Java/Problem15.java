// solution took 1 ms :)

//Math reference: http://en.wikipedia.org/wiki/Binomial_coefficient

import java.math.BigInteger;

class Problem15
{
	public final static int SIZE = 20;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//Start timer
		long tik = System.nanoTime();
		
		//We know you will have to go SIZE moves right, and SIZE moves down
		// to reach the bottom corner; so the number of moves will be SIZE + SIZE = 2*SIZE
		//We also know that half will be right, half will be down; so we will have half
		// right and half down. If we know where all the rights (or downs) are, we then know where
		// the opposite moves are, so we are choosing n positions from 2*SIZE available positions
		//In math terms, we are finding 2*SIZE choose SIZE
		System.out.println(binomialCoeff(2*SIZE, SIZE));
		
		//Stop Timer
		long tok = System.nanoTime();
		System.out.println("Solution took " + ((tok - tik)/1000000) + " ms");
	}
	
	//Calculates the binomial coeff of n choose k
	// i.e. n!/(k! * (n - k)!)
	public static BigInteger binomialCoeff(int n, int k){
		return factorial(n).divide((factorial(k).multiply(factorial(n - k))));
	}
	
	//Calculates factorial of n
	public static BigInteger factorial(int n){
		BigInteger ans = BigInteger.ONE;
		while(n > 1){
			ans = ans.multiply(BigInteger.valueOf(n--));
		}
		return ans;
	}
	
}