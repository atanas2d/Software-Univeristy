package chapter07_arrays;

public class Exr17_DFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = { 
			{ 1, 3, 3, 4, },
			{ 1, 3, 1, 2, },
			{ 1, 1, 1, 1, },
			{ 5, 1, 5, 5, },
		};
		
		int [][] outputMatrix = new int[4][4];
		
		int [] arrx = new int[100];
		int [] arry = new int[100];
		int head = 0;
		int tail = 0;
		
		while (head >= tail) {
			int x = arrx[head];
			int y = arry[head];
			
			int cellValue = matrix[x][y];
			
			if (outputMatrix[x][y] == 0) {			
				outputMatrix[x][y] = cellValue;
				
				if (x < 3 && cellValue == matrix[x+1][y]) {
					tail++;
					arrx[tail] = x+1;
					arry[tail] = y;
				}
				if (x > 0 && cellValue == matrix[x-1][y]) {
					tail++;
					arrx[tail] = x-1;
					arry[tail] = y;
				}
				if (y < 3 && cellValue == matrix[x][y+1]) {
					tail++;
					arrx[tail] = x;
					arry[tail] = y+1;
				}
				if (y > 0 && cellValue == matrix[x][y-1]) {
					tail++;
					arrx[tail] = x;
					arry[tail] = y-1;
				}
			}
			
			head++;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(outputMatrix[j][i] + " ");
			}
			System.out.println();
		}
	}

}
