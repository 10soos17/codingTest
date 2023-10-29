package coding06_algo31_40;

import java.util.Scanner;

//https://www.youtube.com/watch?v=JyaK14AhGm4&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=32
public class FactorialRecursion31 {

	//재귀함수 -> 반드시 탈출조건 써야함
	public static int calFact(int i) {

		if(i == 1) {
			return 1;
		}

		return i * calFact(i-1);

	}

	public static void main(String[] args) {
		//5
		//120

		int input;
		Scanner scan = new Scanner(System.in);

		input = scan.nextInt();
		int ans = 0;

		ans = calFact(input);

		System.out.println(ans);

	}

}
