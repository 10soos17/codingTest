package newCoding0423;

import java.util.TreeMap;

//프로그래머스 정답 중 1
public class T2_fees2 {
	public static void main(String[] args) {
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

    public static int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
    public static int[] solution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String temp[] = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0, ans[] = new int[map.size()];
        for(int time : map.values()) {
            if(time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if(time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }
}