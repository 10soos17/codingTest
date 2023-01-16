package coding03_algo1_13;

//n*n 형태의 숫자 사각형 출력 
public class SquareRowCol4 {

	public static void main(String[] args) {
	
//		//4
//		//answer : 1 2 3 4
//		//         2 4 6 8
//		//         3 6 9 12
//		//         4 8 12 16
//
//		int num = 5;
//		int arr [][] = new int[num][num];
//		
//		for(int i=0;i<num;i++) {
//			for(int j=0;j<num;j++) {
//				arr[i][j] = (j+1)*(i+1);
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println("\n");
//		}
		
		int n=5;
		int arr[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = (i+1)*(j+1);
			}
		}
		

	}
}
