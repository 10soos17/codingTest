package coding06_algo31_40;

import java.util.Scanner;

public class PlusRecursion32 {
	
	public static int calAccSum(int start, int end) {
		
		if(start == end) {
			return start;
		}
		return start + calAccSum(start+1, end);
	}

	public static void main(String[] args) {
		int start;
		int end;
		Scanner scan = new Scanner(System.in);
		
		start = scan.nextInt();
		end = scan.nextInt();
		
		int ans = 0;
		
		ans = calAccSum(start, end);
		
		System.out.println("acc sum = " + ans);

	}

}
