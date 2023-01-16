package newCoding0423;

import java.util.Arrays;
import java.util.HashMap;

public class T2_fees1 {
	public static void main(String[] args) {
//		주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 
//		차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.
//		
//		어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
//		0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
//		00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
//		누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
//		누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
//		초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
//		⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
//		주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
		// 기본 시간(분) 기본 요금(원) 단위 시간(분) 단위 요금
		
		//[120, 0, 60, 591], ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]
		int[] f = {120, 0, 60, 591};//{ 180, 5000, 10, 600 };
		String[] r = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
		//{ "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN","18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		// [14600, 34400, 5000]
		int[] result = solution(f, r);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] fees, String[] records) {
		int[] answer = {};

		HashMap<String, String> check = new HashMap<>();
		HashMap<String, Integer> myFee = new HashMap<>();

		for (String s : records) {
			String[] list = s.split(" ");
			// System.out.println(check.get(s));
			if (check.get(list[1]) == null) {
				check.put(list[1], list[0]);
				System.out.println(list[1]);
				continue;
			}
			// cal();
			String[] before = check.get(list[1]).split(":");
			String[] after = list[0].split(":");

			int bHour = Integer.parseInt(before[0]);
			int bMinute = Integer.parseInt(before[1]);
			int aHour = Integer.parseInt(after[0]);
			int aMinute = Integer.parseInt(after[1]);
			System.out.println(bHour + ":" + bMinute + "," + aHour + ":" + aMinute);
			if (bMinute > aMinute) {
				aHour -= 1;
				aMinute += 60;
			}
			int total = (aHour - bHour) * 60 + aMinute - bMinute;
			System.out.println("total:" + total);
			if (myFee.containsKey(list[1])) {
				myFee.put(list[1], myFee.get(list[1]) + total);
				check.put(list[1], null);
				continue;
			}
			myFee.put(list[1], total);
			check.put(list[1], null);
		}

		for (String s : check.keySet()) {
			if (check.get(s) != null) {
				// cal();
				String[] before = check.get(s).split(":");

				int bHour = Integer.parseInt(before[0]);
				int bMinute = Integer.parseInt(before[1]);
				int aHour = 23;
				int aMinute = 59;

				int total = (23 - bHour) * 60 + 59 - bMinute;

				if (myFee.containsKey(s)) {
					myFee.put(s, myFee.get(s) + total);
					continue;
				}
				myFee.put(s, total);
			}
		}
		
		// 결과 출력
		Object[] mapkey = myFee.keySet().toArray();
		Arrays.sort(mapkey);
		answer = new int[mapkey.length];
		int i = 0;
		for (String nKey : myFee.keySet()) {
			System.out.println(nKey+":"+myFee.get(mapkey[i]));
			if (myFee.get(mapkey[i]) <= fees[0]) {
				answer[i] = fees[1];
				System.out.println(answer[i]);
				i++;
				continue;
			}
			int rem = (myFee.get(mapkey[i]) - fees[0]) % fees[2];
			int num = (myFee.get(mapkey[i]) - fees[0]) / fees[2];
			if(rem > 0) {
				num+=1;
			}
			int resFee = fees[1] + num * fees[3];

			answer[i] = resFee;
			System.out.println(answer[i]);
			i++;

		}
		return answer;
	}
}
