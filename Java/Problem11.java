import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Problem11 {
	
	public static final int SIZE = 20;
	
	public static void main(String[] args) {
		
		Scanner in = null;
		try {
			in = new Scanner(new File("Problem11.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int[][] block = new int[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				block[i][j] = in.nextInt();
		
		long max = 0;
		//Check horizontal
		for(int row = 0; row < SIZE; row++){
			for(int col = 0; col + 3 < SIZE; col++){
				int sum = block[row][col] * block[row][col + 1] * block[row][col + 2] * block[row][col + 3];
				if(sum > max) max = sum;
			}
		}
		
		//Check vertical
		for(int row = 0; row + 3 < SIZE; row++){
			for(int col = 0; col < SIZE; col++){
				int sum = block[row][col] * block[row + 1][col] * block[row + 2][col] * block[row + 3][col];
				if(sum > max) max = sum;
			}
		}
		
		//Check \ diagonal 
		for(int row = 0; row + 3 < SIZE; row++){
			for(int col = 0; col + 3 < SIZE; col++){
				int sum = block[row][col] * block[row + 1][col + 1] * block[row + 2][col + 2] * block[row + 3][col + 3];
				if(sum > max) max = sum;
			}
		}
		
		//Check / diagonal
		for(int row = 3; row < SIZE; row++){
			for(int col = 0; col + 3 < SIZE; col++){
				int sum = block[row][col] * block[row - 1][col + 1] * block[row - 2][col + 2] * block[row - 3][col + 3];
				if(sum > max) max = sum;
			}
		}
		
		System.out.println(max);
	}

}
