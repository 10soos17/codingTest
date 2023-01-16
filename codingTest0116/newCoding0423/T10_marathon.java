package newCoding0423;

import java.util.Arrays;
import java.util.HashMap;

class T10_marathon {
//	마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
//	완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
//	완주하지 못한 선수의 이름을 return
//			
//			completion의 길이는 participant의 길이보다 1 작습니다.
//			참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//			참가자 중에는 동명이인이 있을 수 있습니다.
//			
//			["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"

	public static void main(String[] args) {
		String[] people = { "x", "stanko", "x", "ana" };
		String[] record = { "stanko", "ana", "x" };
		
		String res = solution(people, record);
		System.out.println("res:" + res);
		
		res = solution2(people, record);
		System.out.println("res:" + res);
		
		res = solution3(people, record);
		System.out.println("res:" + res);

	}

	public static String solution(String[] people, String[] record) {
		String answer = "";
		Arrays.sort(people);
		Arrays.sort(record);

		for (int i = 0; i < people.length; i++) {
			if (i == record.length) {
				answer = people[i];
				break;
			}
			if (people[i].equals(record[i])) {
				continue;
			}
			answer = people[i];
			break;
		}
		System.out.println(answer);
		return answer;

	}

	// 프로그래머스 풀이
	public static String solution2(String[] people, String[] record) {

		Arrays.sort(people);
		Arrays.sort(record);

		int i; // i를 밖에서 선언시, 루프 돌고 끝났을 떄, people 배열 인덱스로 리턴가능하기에 사용
		for (i = 0; i < record.length; i++) {
			
			System.out.println(i);
			
			if (!people[i].equals(record[i])) {
				return people[i];
			}
		}
		
		System.out.println("out:" + i);
		return people[i];
	}

//프로그래머스 풀이
	public static String solution3(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}
}