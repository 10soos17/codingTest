package newCoding0628_level1;

import java.util.Arrays;
import java.util.Comparator;

class T25_sortDivisorNum {
//	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환
//	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환
//	arr	divisor	return
//			[5, 9, 7, 10]	5	[5, 10]
//			[2, 36, 1, 3]	1	[1, 2, 3, 36]
//			[3,2,6]	10	[-1]

	public static void main(String[] args) {

		int[] n = { 5, 9, 7, 10 };
		int m = 5;

		int[] res = solution(n, m);

		for (int i : res) {
			System.out.println(i);
		}

	}

	public static int[] solution(int[] n, int m) {

		   int[] a = new int[n.length];
			int cnt = 0;
			for (int i = 0; i < n.length; i++) {
				if (n[i] % m == 0) {
					a[cnt] = n[i];
					cnt++;
				}
			}
			if(cnt ==0)return new int[]{-1};

			int[] answer = new int[cnt];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = a[i];
			}
			Arrays.sort(answer);
	        
	        return answer;
	}

}