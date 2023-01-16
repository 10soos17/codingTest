package coding06_algo31_40;

import java.util.Scanner;

//점화식 활용
//[n] = [n-1] + [n-2] + [n-3] 그 전의 경우의 수를 축적 
//https://www.youtube.com/watch?v=7V5JUtLpVdQ&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=40

public class PlusOneTwoThreeRecursion39 {

	static int cache[] = new int[1000];
	
	public static int doFunc(int n) {
		
		if(cache[n] != 0) {
			return cache[n];
		}
		return cache[n] = doFunc(n-1) + doFunc(n-2) + doFunc(n-3);
 		
	}
	public static void main(String[] args) {
		//정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램
		//ex.input: 4 7 10
		//   output: 7 44 274
		
		int n;
		cache[1] = 1;
		cache[2] = 2;
		cache[3] = 4;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(doFunc(n));
		
		

	}

}
