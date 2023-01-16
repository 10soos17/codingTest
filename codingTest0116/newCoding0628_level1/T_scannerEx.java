package newCoding0628_level1;

import java.util.Scanner;

public class T_scannerEx {


	public static void main(String[] args) {
		int answer = 0;
		int limit = 2;
		int limitCnt=0;

		Scanner s = new Scanner(System.in);
		int fir = s.nextInt();
		int lenLimit = fir;	
		int cnt = 0;
		
		int[][] a = new int[limit][lenLimit];

		while (limitCnt < limit) {
			
			while (lenLimit > 0) {

				a[limitCnt][cnt] = s.nextInt();
				cnt++;
				lenLimit--;
			}
			
			limitCnt++;
			cnt = 0;
			lenLimit = fir;
			
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.println(a[i][j]);
			}
		}
	}

}