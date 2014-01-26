public class Problem7{
    
    private static final int TARGET = 10001;
    private static final int ROOF = 10000000;
    
     public static void main(String []args){
         
        //Initialize to true
        boolean[] isPrime = new boolean[ROOF];
        for(int i = 2; i < isPrime.length; i++)
            isPrime[i] = true;
        
        //Sieve algorithm, eliminating multiples
        for(int i = 2; i < isPrime.length; i++)
        	for(int j = i*2; j < isPrime.length; j+=i)
        		isPrime[j] = false;
        
		//Count the number of primes
		int count = 0, i = 1;
        while(count < TARGET){
            i++;
            if(isPrime[i]) {
                count++;
            }
        }
        System.out.println(i);
	}
}
