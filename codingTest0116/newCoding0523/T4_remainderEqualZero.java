package newCoding0523;

import java.util.ArrayList;
import java.util.Arrays;

//array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수
//divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환
//
//arr	divisor	return
//[5, 9, 7, 10]	5	[5, 10]
//[2, 36, 1, 3]	1	[1, 2, 3, 36]
//[3,2,6]	10	[-1]

public class T4_remainderEqualZero {
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};//{ 5, 9, 7, 10 };
		int n = 5;
		int[] answer = solution2(arr, n);

		for (int i : answer) {
			System.out.println(i);
		}

	}
//testcase error
	public static int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();

		Arrays.sort(arr);

		if(arr[arr.length-1]<divisor) {
			answer = new int[] {-1};
			return answer;
		}

		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]<divisor) break;

			if(arr[i]%divisor==0) {
				list.add(arr[i]);
			}
		}

		answer=new int[list.size()];

		for(int i=0;i< list.size();i++) {
			answer[list.size()-i-1]=list.get(i);
		}

		return answer;
	}

	//프로그래머스정답
	//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=Arrays.stream
	public static int[] solution2(int[] arr, int divisor) {

          int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();

          if(answer.length == 0) answer = new int[] {-1};

          Arrays.sort(answer);

          return answer;
  }

}
