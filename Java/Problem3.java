public class Problem3{
    private static final long NUM = 600851475143L;
    
     public static void main(String []args){
         
        //Initialize to true
        boolean[] isPrime = new boolean[(int)Math.floor(Math.sqrt(NUM)) + 1];
        for(int i = 2; i < isPrime.length; i++)
        	isPrime[i] = true;
        
        //Sieve algorithm, eliminating multiples
        for(int i = 2; i < isPrime.length; i++)
        	for(int j = i*2; j < isPrime.length; j+=i)
        		isPrime[j] = false;
        
		//Loop from the bottom down and find the largest prime multiple
        for(int i = isPrime.length - 1; i > 0; i--){
            if(isPrime[i] && NUM % i == 0){
                System.out.println(i);
                break;
            }
        }
	}
}
