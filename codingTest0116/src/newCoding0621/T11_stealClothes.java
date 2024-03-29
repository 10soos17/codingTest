package newCoding0621;

import java.util.Arrays;

//다시풀기


//여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
//바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
//예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
//최대한 많은 학생이 체육수업을 들어야 합니다.
//
//전체 학생의 수 n,
//체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
//여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
//체육수업을 들을 수 있는 학생의 최댓값을 return
//
//제한사항
//전체 학생의 수는 2명 이상 30명 이하입니다.
//체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
//여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
//이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
//남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
//
//입출력 예
//n	lost	reserve	return
//5	[2, 4]	[1, 3, 5]	5
//5	[2, 4]	[3]	4
//3	[3]	[1]	2

public class T11_stealClothes {
	public static void main(String[] args) {
		int n = 3;
		int[] a = { 3 };
		int[] b = { 1 };
		int answer = solution(n, a, b);

		System.out.println(answer);

	}

	public static int solution(int n, int[] a, int[] b) {
		int answer = n - a.length;
		int idx = 0;
		Arrays.sort(a);
		Arrays.sort(b);

		for (int element : b) {

			if (element == a[idx]) {
				answer--;
				idx++;
				if (idx >= a.length) return answer;
				continue;
			}

			for (int j = idx; j < a.length; j++) {
				idx++;
				if (Math.abs(element - a[j]) == 1) {
					answer++;
					break;
				}
			}
			if (idx >= a.length) return answer;

		}
		return answer;
	}

}