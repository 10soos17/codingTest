package coding07_algo41_50;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//40번 DP버전(동적프로그래밍)

//정수 x
//3으로 나누어 떨어지면, 3으로 나눈다
//2로 나누어 떨어지면, 2로 나눈다
//1을 뺀다
//최소 횟수 출력
//https://www.youtube.com/watch?v=RKLsBMhEvFw&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=42
public class MakeOne41 {

	static int[] ans = new int[1000001];

	public static void main(String[] args) {
		ans[2] = 1;
		ans[3] = 1;

		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		for(int i = 4; i <= 1000000; i++) {

			int a = 99999, b = 99999, c = 99999;

			for(int w = 1; w <= 3; w++) {

				if(w == 1) {
					a = ans[i-1];
				}else if(w == 2) {
					if(i %2 == 0) {
						b = ans[i/2];
					}
				}else if(w==3) {
					if(i % 3 == 0) {
						c = ans[i / 3];
					}
				}
			}

			int min = Collections.min(Arrays.asList(a, b, c));

			ans[i] = 1 + min;
		}

		System.out.println(ans[input]);

	}

}
