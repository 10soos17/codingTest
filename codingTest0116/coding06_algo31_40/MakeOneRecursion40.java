package coding06_algo31_40;

import java.util.Scanner;

//정수 x
//3으로 나누어 떨어지면, 3으로 나눈다
//2로 나누어 떨어지면, 2로 나눈다
//1을 뺀다
//최소 횟수 출력

//https://www.youtube.com/watch?v=2fLeDoSSqPA&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=41
public class MakeOneRecursion40 {
	public static int min = 99999999;

	public static void doFunc(int num, int way, int cnt) {
		if(way == 3 && num % 3 == 0) {
			cnt++;
			num /= way;
			for(int i=1; i <= 3; i++) {
				doFunc(num, way, cnt);
			}
		}else if(way == 2 && num % 2 == 0) {
			cnt ++;
			num /= way;
			for(int i = 1; i <= 3; i++) {
				doFunc(num, way, cnt);
			}
		}else if(num > 2) {
			cnt ++;
			num -=1;
			for(int i = 1; i <=3; i++) {
				doFunc(num, way, cnt);
			}
		}

		if(num == 1 && cnt < min) {
			min = cnt;
			return;
		}
	}

	public static void main(String[] args) {
		//ex. input 2, 10
		//	  output 1, 3

		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 1; i <= 3; i++) {
			doFunc(n, i, 0);

		}
		System.out.println(min);



	}

}
