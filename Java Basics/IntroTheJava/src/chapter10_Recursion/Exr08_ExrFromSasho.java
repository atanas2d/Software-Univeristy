package chapter10_Recursion;

public class Exr08_ExrFromSasho {
	public static int[] arr = {1,2,3};	
	public static int[][] bArr = {
		{0,0,0},
		{1,0,0},
		{0,1,0},
		{0,0,1},
		{1,1,0},
		{1,0,1},
		{0,1,1},
		{1,1,1},
	};
	public static int k1 = 0;
	
	public static void print() {
		System.out.print("( ");
		for (int i = 0; i < bArr[k1].length; i++) {
			if (bArr[k1][i] == 1) {
				System.out.printf("%d, ", arr[i]);
			}
		}
		System.out.print(" )");
	}
	
	public static void rec (int k) {
		if (k == bArr.length) {			
			return;
		}	
		
		k1 = k;
		print();
		
		rec (k + 1);
	}
	
	public static void main(String[] args) {
		 
		rec (k1);
	}

}
