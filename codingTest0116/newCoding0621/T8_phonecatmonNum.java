package newCoding0621;

import java.util.Arrays;

//N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다
//폰켓몬은 종류에 따라 번호를 붙여 구분
//따라서 같은 종류의 폰켓몬은 같은 번호
//예를 들어 연구실에 총 4마리의 폰켓몬이 있고, 
//각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면 
//이는 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다. 
//이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.
//
//첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
//첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
//첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
//두 번째(1번), 세 번째(2번) 폰켓몬을 선택
//두 번째(1번), 네 번째(3번) 폰켓몬을 선택
//세 번째(2번), 네 번째(3번) 폰켓몬을 선택
//
//따라서 위 예시에서 가질 수 있는 폰켓몬 종류 수의 최댓값은 2가 됩니다.
//N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
//N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 
//그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수
//		
//		nums	result
//		[3,1,2,3]	2
//		[3,3,3,2,2,4]	3
//		[3,3,3,2,2,2]	2
//nums 길이는 항상 짝수
public class T8_phonecatmonNum {
	public static void main(String[] args) {

		int[] a = {3,3,3,2,2,2};
		int answer = solution(a);

		System.out.println(answer);

	}

	public static int solution(int[] a) {
		int answer = 1;
		int limit = a.length/2;

		Arrays.sort(a);
		
		for(int i=1;i<a.length;i++){
			System.out.println(a[i]);
			if(a[i-1] != a[i]) {
				//System.out.println(a[i]);
				if(limit<=answer) {
					return answer;
				}
				answer++;
			}
		
		}

		return answer;
	}
}