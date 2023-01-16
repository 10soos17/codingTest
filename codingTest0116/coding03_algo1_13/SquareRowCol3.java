package coding03_algo1_13;

//n*n 형태의 숫자 사각형 출력 
//https://www.youtube.com/watch?v=NldRYbDqgKw&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=11
public class SquareRowCol3 {

	public static void main(String[] args) {
	
//		//4
//		//answer : 1 2 3 4
//		//         8 7 6 5
//		//         9 10 11 12
//		//         16 15 14 13
//		int num = 5;
//		
//		int arr[][] = new int[num][num];
//		
//		for(int i=0; i<num; i++) {
//			
//			if(i%2 == 0) {//짝수행일 경우 
//				for(int j=0;j<num;j++){
//					arr[i][j] = i*num+j+1;
//					System.out.printf("%d ", arr[i][j]);
//				}
//			}else {//홀수행일 경우 
//				for(int j=num-1;j>=0;j--){
//					arr[i][j] = i*num+j+1;
//					System.out.printf("%d ", arr[i][j]);
//				}
//				
//			}
//			System.out.println("\n");
//		}
		int n=5;
		int arr[][] = new int [n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i%2 !=0) {
					arr[i][n-j-1] = i*n+j+1;
				}else {
					arr[i][j] = i*n+j+1;
				}
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
