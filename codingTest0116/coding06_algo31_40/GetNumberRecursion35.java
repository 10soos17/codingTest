package coding06_algo31_40;

import java.util.Scanner;

//https://www.youtube.com/watch?v=-SugL4jfpxY&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=36
public class GetNumberRecursion35 {
	
	public static void extract(int N) {
		if(N / 10 == 0) {
			System.out.println(N);
			return;
		}
		
		extract(N/10);
		System.out.println(N%10);
	}

	public static void main(String[] args) {
		//2312
		
		//2
		//3
		//1
		//2
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		extract(input);
	}

}
