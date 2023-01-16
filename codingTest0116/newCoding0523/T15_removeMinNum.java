package newCoding0523;

import java.util.Arrays;

//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
//단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
//예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 
//arr	return
//[4,3,2,1]	[4,3,2]
//[10]	[-1]
public class T15_removeMinNum {
	public static void main(String[] args) {

		int[] arr = { 4, 2, 3, 5, 1 };

		int[] answer = solution(arr);
		for (int i : answer) {

			System.out.println(i);
		}

		answer = solution(arr);

	}

	public static int[] solution(int[] arr) {

		if (arr.length == 1) {
			return new int[] { -1 };
		}

		int idx = 0;
		int[] answer = new int[arr.length - 1];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < arr[idx]) {
				idx = i;
			}

		}

		int cnt = -1;
		for (int i = 0; i < arr.length; i++) {
			cnt++;
			if (i == idx) {
				cnt--;
				continue;
			}
			answer[cnt] = arr[i];
		}

		return answer;
	}
}
