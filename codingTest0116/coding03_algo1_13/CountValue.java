package coding03_algo1_13;

import java.util.Scanner;

//https://www.youtube.com/watch?v=C-HElAETJVo&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=4
public class CountValue {

	public static void main(String[] args) {
		
//		//1. Scanner 입력값 받기 
//		Scanner scan = new Scanner(System.in);
//		
//		int [] inputNum = new int[10];
//		
//		for(int i=0; i<10;i++) {
//			inputNum[i] = scan.nextInt();
//		}
//		//ex. 1 2 2 3 1 4 2 2 4 3
//		
//		int [] mode = new int [10];
//		
//		for(int i = 0; i <10; i++) {
//			mode[inputNum[i]]++;
//			
//		}
//		
//		int modeNum = 0;
//		int modeCnt = 0;
//		
//		for(int i=0;i<10; i++) {
//			if(modeCnt < mode[i]) {
//				modeCnt = mode[i];
//				modeNum = i;
//			}
//		}
//		
//		System.out.println("최빈수: "+modeNum +",cnt: "+modeCnt);

		
		//2.
		int [] numList = new int[] {1,2,2,3,1,4,2,2,4,3};
		
		int [] idx = new int[10];
		
		for(int i=0;i<10;i++) {
			idx[numList[i]]++;
		}
		
		int resNum = 0;
		int resNumCount = 0;
		
		for(int i=0;i<10;i++) {
			if(resNumCount < idx[i]) {
				resNumCount = idx[i];
				resNum = i;
			}
		}
		System.out.println("최빈수: "+resNum +",cnt: "+resNumCount);
		
		for(int i = 0;i<numList.length;i++) {
			idx[numList[i]]++;
		}
	
	
		
	}
	
	

}
