package Tets9_SKC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//order by sum(salary) desc

//SELECT distinct experience exp, count(experience) count from assessments group by exp;

class T1 {

//	static int r = 3;
//	static int[] l = { 1,2,7,6,4};
//	static int sum=0;
//	static int cnt=0;
	public static void main(String[] args) {

		String id = "bird100";

		int n = 7;
		int m = 24;
		int p = 4;

		int[] l = { 2, 4 };
		int[] ll = { 1, 3, 5 };

		String[] sl = { "14:13:25 new123 register",
				"14:36:41 new123 clearTutorial",
				"14:43:02 new123 clearBattle",
				"14:43:51 new123 getReward",
				"15:13:25 hacker123 register",
				"15:14:29 hacker123 getReward",
				"15:15:25 lucky777 register",
				"15:15:29 lucky777 getReward",
				"15:15:36 lucky777 clearTutorial",
				"15:15:46 lucky777 clearBattle",
				"15:24:51 super999 getReward",
				"15:24:55 super999 getReward"};

		String[] sll = { "register", "clearTutorial", "clearBattle", "getReward" };

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };

		String[] res = solution(sl, sll);
		System.out.println(res);

	}

	public static String[] solution(String[] sl, String[] sll) {

		Map<String, Integer> map = new HashMap<>();
		List<String> res = new ArrayList<>();
		for (String element : sl) {
			String[] temp = element.split(" ");

			System.out.println(temp[1]);
			if (!map.containsKey(temp[1])) {
				if (!sll[0].equals(temp[2])) {
					res.add(temp[1]);
					map.put(temp[1], -1);
					continue;
				}
				map.put(temp[1], 0);
			} else {
				int idx = map.get(temp[1]);
				if (idx != -1) {
					if (!sll[idx + 1].equals(temp[2])) {
						res.add(temp[1]);
						map.put(temp[1], -1);
						continue;
					}
					map.put(temp[1], idx + 1);

				}

			}

		}

		if(res.size() == 0) {
			String[] answer =  {"-1"};
			return answer;
		}

		String[] answer = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}
		Arrays.sort(answer);
		System.out.println(answer.length);

		return answer;
	}

}