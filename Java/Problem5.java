public class Problem5{
    
    public static void main(String []args){
        
		//This can probably be optimized
        for(int i = 20*20; i < 1000000000; i++){
            if(isDivisible(i)){
                System.out.println(i);
                break;
            }
        }
        System.out.println("Done");
	}
    
	//Only needs to be divisible by 20-11 because of their factors
    public static boolean isDivisible(int i){
        return (i % 20 == 0) && (i % 19 == 0) && (i % 18 == 0) &&
               (i % 17 == 0) && (i % 16 == 0) && (i % 15 == 0) &&
               (i % 14 == 0) && (i % 13 == 0) && (i % 12 == 0) &&
               (i % 11 == 0);
    }
}
