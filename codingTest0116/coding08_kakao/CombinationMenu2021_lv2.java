package coding08_kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationMenu2021_lv2 {

	static ArrayList<HashMap<String, Integer>> FoodMaps = new ArrayList<>();
	static int[] MaxCnt = new int[11];

	public static void main(String[] args) {



		/*
		 * orders	course	result
			["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
			["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
			["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
		 */

		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};

		solution(orders, course);


	}


	static void comb(char[] str, int pos, StringBuilder candi) {
		if(pos >= str.length) {
			int len = candi.length();
			if(len >=2) {
				int cnt = FoodMaps.get(len).getOrDefault(candi.toString(),0)+1;
				FoodMaps.get(len).put(candi.toString(), cnt);
				MaxCnt[len] = Math.max(MaxCnt[len], cnt);
			}
			return;
		}

		comb(str, pos+1, candi.append(str[pos]));
		candi.setLength(candi.length()-1);
		comb(str, pos+1, candi);
	}


	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};

		for(int i=0; i < 11;i++) {
			FoodMaps.add(new HashMap<String, Integer>());
		}

		for(String str : orders) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			comb(arr,0,new StringBuilder());
		}

		List<String> list = new ArrayList<>();//정렬위해서 List에 다시 저장
		for(int len:course) {
			for(Map.Entry<String, Integer> entry:FoodMaps.get(len).entrySet()) {
				if(entry.getValue() >=2 && entry.getValue() == MaxCnt[len]) {
					list.add(entry.getKey());
				}
			}
		}
		Collections.sort(list);

		String[] anwser = new String[list.size()];
		for(int i=0;i<list.size();i++){
			answer[i] = list.get(i);
		}
		return answer;

	}
}
