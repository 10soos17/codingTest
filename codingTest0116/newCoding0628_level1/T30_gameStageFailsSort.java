package newCoding0628_level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T30_gameStageFailsSort {
	public static void main(String[] args) {
		int n = 5;
		int[] nl = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] res = solution(nl, n);
	}

	public static class Fail {
		int stage;
		double fail;

		Fail(int stage, double fail) {
			this.stage = stage;
			this.fail = fail;
		}
	}

	// 실패율 내림차순
	// 실패율 같으면 스테이지번호 오름차순
	static Comparator<Fail> comp = new Comparator<Fail>() {

		@Override
		public int compare(Fail a, Fail b) {
			if (a.fail < b.fail)
				return 1;
			else if (a.fail > b.fail)
				return -1;
			else {
				if (a.stage > b.stage)
					return 1;
				else if (a.stage < b.stage)
					return -1;
				else
					return 0;
			}
		}
	};

//	}
	// 1부터
	// 정렬
	// stageCnt, 현유저 / 총유저
	// 실패율 - 그 스테이지 유저 / 그 인덱스부터 끝
	//
	// while n
	//
	public static int[] solution(int[] nl, int n) {
		int[] answer = new int[n];
		List<Fail> fails = new ArrayList<>();
		int cnt = 1;

		Arrays.sort(nl);
		while (cnt <= n) {
			int start = 0;
			int stay = 0;
			int pass = 0;
			for (int i = 0; i < nl.length; i++) {
				if (nl[i] == cnt) {
					stay += 1;
				}
				if (nl[i] > cnt) {
					start = i - stay;
					System.out.println("stay:" + stay);
					System.out.println("start:" + start);
					break;
				}
			}
			pass = nl.length - start;
			System.out.println("pass:" + pass);

			fails.add(new Fail(cnt, (double) stay / pass));
			System.out.println("fails:"+ (double) stay / pass+"\n");
			cnt += 1;
		}
		Collections.sort(fails,comp);
		
		for(int i=0;i<n;i++) {
			answer[i] = fails.get(i).stage;
			System.out.println(answer[i]);
		}

		return answer;
	}

}
