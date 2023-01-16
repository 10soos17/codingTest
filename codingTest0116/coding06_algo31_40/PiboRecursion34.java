package coding06_algo31_40;

import java.util.Scanner;

public class PiboRecursion34 {

	public static int pibo(int N) {
		if(N == 1)
			return 1;
		if (N == 2)
			return 1;
		return pibo(N-1) + pibo(N-2);
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int ans = pibo(N);
		
		System.out.println(ans);

	}

}
