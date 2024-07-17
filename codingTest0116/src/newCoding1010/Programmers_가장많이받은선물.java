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
	static Map<String, Map<String, Integer>> take = new HashMap<>();
	static Map<String, Integer> profit = new HashMap<>();

	public static void main(String[] args) throws Exception {
		String[] friends = { "muzi", "ryan", "frodo", "neo" };
		String[] gifts = { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
				"frodo ryan", "neo muzi" };

		int result = solution(friends, gifts);
		System.out.println(result);
	}

	public static int solution(String[] friends, String[] gifts) {
		int answer = 0;

		Map<String, Integer> nameMap = new HashMap<>();
		for (int i = 0; i < friends.length; i++) {
			nameMap.put(friends[i], 0);
		};

		give = new HashMap<>();
		take = new HashMap<>();

		profit = new HashMap<>(); // 이름 나올떄마다

		for (int i = 0; i < friends.length; i++) {
			give.put(friends[i], nameMap);
			take.put(friends[i], nameMap);
		}

		for (int i = 0; i < gifts.length; i++) {
			String giver = gifts[i].split(" ")[0];
			String taker = gifts[i].split(" ")[1];
			// map.put("key", map.getOrDefault("key", 0) + value);
			// 준경우
			Map<String, Integer> map = give.get(giver);
			Integer count = map.get(taker) + 1;
			map.put(taker, count);
			give.put(giver, map);
			profit.put(giver, profit.getOrDefault(giver, 1) + 1);
			//System.out.println("giver:"+giver);
			//System.out.println("gcnt:"+profit.get(giver));
			
			//받은경우
			Map<String, Integer> map2 = take.get(taker);
			count = map2.get(giver) + 1;
			map2.put(giver, count);
			take.put(taker, map2);
			profit.put(taker, profit.getOrDefault(taker, -1) -1);
			//System.out.println("taker:"+taker);
			//System.out.println("tcnt:"+profit.get(taker));
		}
		//  둘사이 주고받은 게 있으면, 많이 준 사람이 +1 / 기록 없거나 같으면 선물지수 큰 사람 +1 / 선물지수도 같으면 +0
		for (int i = 0; i < friends.length; i++) {
			Integer n = 0;
			String name = friends[i];
			Map<String, Integer> gMap = give.get(name);
			
			for(String s : gMap.keySet()) {
				Integer gCnt = gMap.get(s);
				Map<String, Integer> tMap = take.get(s);
				Integer tCnt = tMap.get(name);
				if(gCnt != 0 && tCnt != 0) {
					// 둘 값 비교
					System.out.println("!=0"+":"+name+gCnt+":"+tCnt);
					if(gCnt > tCnt) {
						n+=1;
						//System.out.println("if(gCnt > tCnt) {");
					}
				}
				else{
					Integer pgCnt = profit.get(name);
					Integer ptCnt = profit.get(s);
					System.out.println(pgCnt);
					System.out.println(ptCnt);
					
					if(pgCnt> ptCnt) {
						n+=1;
						//System.out.println("if(pgCnt> ptCnt) {");
					}
				}
			}
			answer = Math.max(n, answer);
			System.out.println("____ans:"+answer);
		}
		return answer;
	}

}