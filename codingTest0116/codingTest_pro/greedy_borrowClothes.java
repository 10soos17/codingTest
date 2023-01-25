package codingTest_pro;

import java.util.Arrays;

public class greedy_borrowClothes {

	public static void main(String[] args) {
		/*
		 * n lost reserve return 5 [2, 4] [1, 3, 5] 5 5 [2, 4] [3] 4 3 [3] [1] 2
		 */
		int n = 3;
		int[] arr1 = { 3 };
		int[] arr2 = {1 };

		solution(n, arr1, arr2);

	}

	public static int solution(int n, int[] lost, int[] reserve) {

		int m = n;
		m -= lost.length;
		int idx=0;
		int idx2=0;


		Arrays.sort(lost);
		Arrays.sort(reserve);


		for (int i = idx; i < reserve.length; i++) {

			for (int j = idx2; j < lost.length; j++) {


				if(reserve[i] == lost[j]) {
					idx=i+1;
					//idx2 = j+1;
					//break;
				}if(Math.abs(lost[j] - reserve[i]) == 1) {
					m+=1;
					idx+=1;
					idx2 = j+1;
					break;

				}else if(Math.abs(lost[j] - reserve[i]) > 1) {
					if(reserve[i]> lost[j]) {
						idx=i+1;

					}else {
						idx2+=1;
						break;
					}
				}


			}

		}
		System.out.println(m);

		return m;
	}
}