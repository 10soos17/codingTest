package coding05_algo21_30;

import java.util.Scanner;

//음계
//https://www.youtube.com/watch?v=ONOTz6RsPzo&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=30
public class Order29 {
	
	public static void distinct(int input[]) {
		
		boolean aFlag = true;
		boolean bFlag = true;
		
		//ascending
		if(input[0] != 1) {
			aFlag = false;
		}
		
		for(int i = 1; i < input.length-1;i++) {
			if(input[i] - input[i+1] != -1) {
				aFlag = false;
				break;
			}
		}
		//descending
		if(input[0] != 8) {
			bFlag = false;
		}
		
		for(int i = 1; i < input.length-1;i++) {
			if(input[i] - input[i+1] != 1) {
				bFlag = false;
				break;
			}
		}
		
		if(aFlag) {
			System.out.println("ascending");
		}else if(bFlag) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
		
		
		
	}

	public static void main(String[] args) {
		//12345678 ->ascending
		//87654321 -> descending
		//mixed
		
		Scanner scan = new Scanner(System.in);
		int input[] = new int[8];
		
		for(int i=0;i<input.length;i++) {
			input[i] = scan.nextInt();
		}
		
		distinct(input);

	}

}
