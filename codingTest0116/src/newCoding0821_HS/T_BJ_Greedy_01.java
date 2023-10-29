package newCoding0821_HS;

import java.util.Scanner;

public class T_BJ_Greedy_01 {


	public static void calc(int sugar){//int[] tmp) {
//		int cnt = Integer.MAX_VALUE/2;
//		int sum=0;
//		int tmp = sugar ;
//		int[] size = new int[] {3,5,7};
//		while(true) {
//
//			if(tmp<0) {
//				return;
//			}
//			while() {
//			tmp = sugar/size[i];
//			}
//		}




	}

	public static void greedy(int dep, int sugar, int start, int[] tmp) {
//		int answer=0;
//
//		int[] size = new int[] {3,5 };
//
//		if(dep == size.length) {
//			//calc(tmp);
//		}
//
//		for(int i= start;i<size.length;i++) {
//			tmp[dep] = size[i];
//			greedy(dep+1,sugar,i+1, tmp);
//
//		}
//


		//System.out.println();
		int answer = 0;

		while(true) {

			if(sugar%5==0) {
				answer += sugar/5;
				break;
			}else {
				answer++;
				sugar -= 3;
			}

			if(sugar<0) {
				answer = -1;
				break;
			}

			if(sugar==0) break;

		}
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();

		//greedy(sugar);


	}


}