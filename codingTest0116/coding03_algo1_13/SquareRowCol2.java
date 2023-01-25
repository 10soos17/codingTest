package coding03_algo1_13;

//n*n 형태의 숫자 사각형 출력
//https://www.youtube.com/watch?v=NldRYbDqgKw&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=11
public class SquareRowCol2 {

	public static void main(String[] args) {

//		//4
//		//answer : 1 5 9 13
//		//         2 6 10 14
//		//         3 7 11 15
//		//         4 8 12 16
//
//		int num = 5;
//		int n = 1;
//
//		int arr[][] = new int[num][num];
//
//		for(int i=0;i<num;i++) {
//
//			for(int j=0;j<num;j++) {
//
//				arr[j][i] = n;//같은 열번호값 차례로 넣기
//				n++;
//
//				//or arr[j][i] = i*n + j + 1;
//
//			}
//		}
//
//		for(int i=0;i<num;i++) {
//			for(int j=0;j<num;j++) {
//				System.out.printf("%3d", arr[i][j]);
//			}
//			System.out.println();
//		}

		int n=5;
		int arr [][] = new int[n][n];

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[j][i] = i*n+j+1;
			}
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
	}
}
