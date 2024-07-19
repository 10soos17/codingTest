package newCoding1010;

import java.util.HashMap;
import java.util.Map;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java
friends	gifts	result
["muzi", "ryan", "frodo", "neo"]	["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]	2
["joy", "brad", "alessandro", "conan", "david"]	["alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"]	4
["a", "b", "c"]	["a b", "b a", "c a", "a c", "a c", "c a"]	0
*/
/*"A B"형태의 문자열입니다. A는 선물을 준 친구의 이름을 B는 선물을 받은 친구의 이름을 의미
 * 
 * 둘사이 주고받은 게 있으면, 많이 준 사람이 +1 / 기록 없거나 같으면 선물지수 큰 사람 +1 / 선물지수도 같으면 +0
 * 
 * 선물지수: 준 선물 - 받은 선물
 * 
 * 답: 선물을 가장 많이 받을 친구가 받을 선물의 수
 */
public class Programmers_가장많이받은선물 {

	static Map<String, Map<String, Integer>> give = new HashMap<>();
	static Map<String, Integer> profit = new HashMap<>();
	public static void main(String[] args) throws Exception {
		String[] friends = {"muzi", "ryan", "frodo", "neo"};
		String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

		int result = solution(friends, gifts);
		System.out.println(result);
	}

	public static int solution(String[] friends, String[] gifts) {
		int answer = 0;

		give = new HashMap<>();
		profit = new HashMap<>(); // 이름 나올떄마다

		for (int i = 0; i < friends.length; i++) {
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < friends.length; j++) {
				map.put(friends[j], 0);
			}
			give.put(friends[i], map);
			profit.put(friends[i], 0);
		}
		for (int i = 0; i < gifts.length; i++) {
			String giver = gifts[i].split(" ")[0];
			String taker = gifts[i].split(" ")[1];
			// 준경우
			Map<String, Integer> map = give.get(giver);
			Integer count = map.get(taker) + 1;
			map.put(taker, count);
			give.put(giver, map);
			profit.put(giver, profit.get(giver) + 1);
			profit.put(taker, profit.get(taker) - 1);
		}
		//  둘사이 주고받은 게 있으면, 많이 준 사람이 +1 / 기록 없거나 같으면 선물지수 큰 사람 +1 / 선물지수도 같으면 +0
		for (int i = 0; i < friends.length; i++) {
			
			Integer n = 0;
			String name = friends[i];
			Map<String, Integer> gMap = give.get(name);
			
			for(String s : gMap.keySet()) {
				
				if(s.equals(name)) continue;
				
				Integer gCnt = gMap.get(s);
				
				Map<String, Integer> sMap = give.get(s);
				Integer tCnt = sMap.get(name);
				
				Integer pgCnt = profit.get(name);
				Integer ptCnt = profit.get(s);
				
				if(gCnt != 0 || tCnt != 0) {
					if(gCnt > tCnt) n+=1;
					else if(gCnt == tCnt && pgCnt > ptCnt) n+=1;
				} else if(pgCnt > ptCnt) n+=1;
			}
			answer = Math.max(n, answer);
		}
		return answer;
	}
}