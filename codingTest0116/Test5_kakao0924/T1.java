package Test5_kakao0924;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class T1 {

//	static int r = 3;
//	static int[] l = { 1,2,7,6,4};
//	static int sum=0;
//	static int cnt=0;
	public static void main(String[] args) {

		String s = "2020.01.01";

		int n = 5;
		int m = 24;
		int p = 4;

		String[] l = {"Z 3","D 5"};//{ "A 6", "B 12", "C 3" };
		String[] ll = { 
				"2019.01.01 D", 
				"2019.11.15 Z", 
				"2019.08.02 D", 
				"2019.07.01 D", 
				"2018.12.28 Z" };

		String[] sl = {};
		String[] sll = {};

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };

		int[] res = solution(s, l, ll);
		for (int i : res) {
			System.out.println(i);
		}

	}

	static int[] solution(String s, String[] l, String[] ll) {
		int[] a = new int [ll.length];
		int cnt=0;
		Map<String, Integer> map = new HashMap<>();
		for (String text : l) {
			String split[] = text.split(" ");
			map.put(split[0], Integer.parseInt(split[1]));
		}
		s= s.replaceAll("[.]", "");
		int thisDate=Integer.parseInt(s);

		System.out.println(s);
		for (int i = 0; i < ll.length; i++) {
			String[] split = ll[i].split(" ");
			String[] dateSplit = split[0].split("[.]");

			int limit = map.get(split[1]);
			int year = Integer.parseInt(dateSplit[0]);
			int month = Integer.parseInt(dateSplit[1]);
			int day = Integer.parseInt(dateSplit[2]);

			year += limit / 12;
			month += limit%12;
			
			if(month>12) {
				year+=1;
				month=month/12;
			}
			if (day == 1) {
				month -= 1;
				day = 28;
				if(month==0) {
					year-=1;
					month=12;
				}
			} else {
				day -= 1;
			}
			
			System.out.println(year + ":" + month + ":" + day);
			String date = ""+year;
			
			date = month<10 ? date+="0"+month : date+month;
			date = day<10 ? date+="0"+day : date+day;
			int numDate = Integer.parseInt(date);
			
			
			if(thisDate > numDate) {
				a[cnt] = i+1;
				cnt++;
			}
		}
		
		int[] answer = new int[cnt];
		for(int i=0;i<answer.length;i++) {
			answer[i] = a[i];
		}
		Arrays.sort(answer);

		return answer;
	}

}