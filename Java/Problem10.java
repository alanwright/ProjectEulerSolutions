
public class Problem10 {

	public static final int ROOF = 2000000;
	
	public static void main(String[] args) {
        //Initialize to true
        boolean[] isPrime = new boolean[ROOF];
        for(int i = 2; i < isPrime.length; i++)
            isPrime[i] = true;
        
        //Sieve algorithm, eliminating multiples
        for(int i = 2; i < isPrime.length; i++)
        	for(int j = i*2; j < isPrime.length; j+=i)
        		isPrime[j] = false;
        
        //Sum
        long sum = 0;
        for(int i = 2; i < isPrime.length; i++)
        	if(isPrime[i]) sum += i;
        
        System.out.println(sum);
	}

}
