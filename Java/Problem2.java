public class Problem2{

     public static void main(String []args){
         
        int currFib = 2;
        int prevFib = 1;
        int sum = 0;
        while(currFib <= 4000000){
            if(currFib % 2 == 0){
                sum += currFib;
            }
            currFib += prevFib;
            prevFib = currFib - prevFib; //prevFib becomes the old currFib
        }
        System.out.println(sum);
     }
}
