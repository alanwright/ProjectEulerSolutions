public class Problem4{
    
    public static void main(String []args){
        int max = -1;
        boolean shouldBreak = false;
        for(int i = 999; i > 99; i--){
            for(int j = 999; j > 99; j--){
                if(isPalindrome(i*j) && i*j > max){
                    max = i*j;
                }
            }
        }
        System.out.println(max);
	}
    
    public static boolean isPalindrome(int n){
        String num = Integer.toString(n);
        for(int i = 0, j = num.length() - 1; i < j; i++, j--){
            if(num.charAt(i) != num.charAt(j))
                return false;
        }
        return true;
    }
}
