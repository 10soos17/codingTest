package coding03_algo1_13;

//n*n 형태의 숫자 사각형 출력
//https://www.youtube.com/watch?v=NldRYbDqgKw&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=11
public class SquareRowCol {

	public static void main(String[] args) {

//		//4
//		//answer : 1 2 3 4
//		//         5 6 7 8
//		//         9 10 11 12
//		//         13 14 15 16
//		int num = 4;
//		int count=1;
//		for(int i=0;i<num;i++) {
//
//			for(int j=0;j<num;j++) {
//				System.out.print(i*num+j+1 + " ");
//			//	System.out.print(count + " ");
//			//	count++;
//			}
//
//
//			System.out.println("\n");
//		}

		int n = 4;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(i*n+j+1+" ");
			}
			System.out.println();
		}



	}

}
