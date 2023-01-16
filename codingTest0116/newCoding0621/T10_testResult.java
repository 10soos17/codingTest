package newCoding0621;

import java.util.ArrayList;

//수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
//
//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
//가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
//
//제한 조건
//시험은 최대 10,000 문제로 구성되어있습니다.
//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬
//
//answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]
public class T10_testResult {
	public static void main(String[] args) {

		int[] a = { 1, 3, 2, 4, 2 };
		ArrayList<Integer> answer = solution(a);

		System.out.println(answer);

	}

	public static ArrayList<Integer> solution(int[] a) {
		int[] answer = new int[3];

		int[] one = { 1, 2, 3, 4, 5 };// 5
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };// 8
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };// 10

		for (int i = 0; i < a.length; i++) {
			if (one[i % 5] == a[i]) {
				answer[0]++;
			}
			if (two[i % 8] == a[i]) {
				answer[1]++;
			}
			if (three[i % 10] == a[i]) {
				answer[2]++;
			}
		}

		int maxVal = Math.max(answer[0], Math.max(answer[1], answer[2]));

		ArrayList<Integer> aa = new ArrayList<>();
		for (int i = 0; i < answer.length; i++) {
			if (maxVal == answer[i]) {
				aa.add(i+1);
			}

		}

		return aa;
	}

}