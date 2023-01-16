package Test2_wanted0702;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int answer=0;
		// int n = 4;// 7
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = (int) Math.sqrt(n)+1;
		
		int i = 1;
	
		if (n % Math.sqrt(n) == 0) {
			answer += n / Math.sqrt(n);
			m = (int) Math.sqrt(n);
		}

		while (i < m) {
			if (n % i == 0) {
				answer += i;
				answer += n / i;
			}

			i++;
		}

		System.out.println(answer);

	}

	
}