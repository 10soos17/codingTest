package newCoding1010;

import java.util.HashMap;
import java.util.Map;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/77486
enroll["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	
referral["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	
seller["young", "john", "tod", "emily", "mary"]	
amount[12, 4, 2, 5, 10]	
result[360, 958, 108, 0, 450, 18, 180, 1080]
*/

public class Programmers_다단계칫솔판매 {

	public static void main(String[] args) throws Exception {
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "sam", "emily", "jaimie", "edward" };
		int[] amount = {2, 3, 5, 4};
		// result[360, 958, 108, 0, 450, 18, 180, 1080]
		int[] result = solution(enroll, referral, seller, amount);
		for (int i : result)
			System.out.println(i);
	}

	static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		Map<String, String> connectMap = new HashMap<>();
		Map<String, Integer> profitMap = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			connectMap.put(enroll[i], referral[i]);
			profitMap.put(enroll[i], 0);
		}
		//connectMap.put("-","-");
		profitMap.put("-", 0);
		for (int i = 0; i < seller.length; i++) {
			int m = amount[i] * 100;
			String now = seller[i];
			profitMap.put(now, profitMap.get(now) + m - (int) (m * 0.1));
			int take = (int) (m * 0.1);
			while (true) {
				String next = connectMap.get(now);
				if (take < 10) {
					profitMap.put(next, profitMap.get(next) + take);
					break;
				}
				profitMap.put(next, profitMap.get(next) + take - (int)(take * 0.1));
				if (next.equals("-")) {
					break;
				}
				take *= 0.1;
				now = next;
			}
		}
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = profitMap.get(enroll[i]);
		}
		return answer;
	}

}