package codingTest_Fasoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

////char 사용시 유의
//(char)(‘0’+val);

////값 포함 여부 체크
//map.containskey(값); => true/false
//list.indexOf(값); => 없으면 -1/있으면 해당인덱스번호

////배열 복사
// Array -> List로 복사
//String[] str = { "d", "a", "b", "c" };
//List<String> list11 = Arrays.asList(str);

//System.arrayCopy(arr1,0,arr2,0,arr1.length);

//arr.copyOf(원본배열, 복사할길이)

//arr.copyOfRange(원본배열, 시작인덱스, 끝인덱스);

////Null 체크
//Object.isNull(Object obj) => null이면 true

////map
//for(타입 변수명 : 맵변수명.keySet()){
//타입 value변수명 = 맵변수명.get(변수명);
//}

//Collections.sort(배열이름);
//Collections.reverse(배열이름);

//String str=“abc”;
//char[] arr;
//arr = str.toCharArray();

//char[] c = {‘a’,b’,c’};
//String cc = String.copyValueOf(c); => “abc”

//int bin = a | b;
//Integer.toBinaryString(bin);

////정규표현식
//Pattern p = Pattern.compile(정규표현식);
//Matcher m = p.matcher(비교할문자열);
//m.find();
//m.groupCount();
//m.group(1);

//ArrayList<Integer> list = new ArrayList<>();
//HashMap<String, Integer> map = new HashMap<>();
public class Test2 {

	public static void main(String[] args) {

		int[][] arr = { { 2, 2 }, { 4, 4 }, { 1, 4 }, { -1, -4 } };// 3

		solution(arr);

	}

	public static int solution(int[][] balloons) {
		int answer = balloons.length;

		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<Integer> list4 = new ArrayList<>();

		int[] arr = new int[balloons.length];
		int cnt = 0;
		for (int i = 0; i < balloons.length; i++) {

			if (balloons[i][0] < 0 && balloons[i][1] > 0) {// -+

				list2.add(balloons[i][1] / balloons[i][0]);

			} else if (balloons[i][0] < 0 && balloons[i][1] < 0) {// --

				list3.add(balloons[i][1] / balloons[i][0]);
			}
			if (balloons[i][0] > 0 && balloons[i][1] < 0) {

				list4.add(balloons[i][1] / balloons[i][0]);
			} else {

				list1.add(balloons[i][1] / balloons[i][0]);
			}
		}
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.sort(list3);
		Collections.sort(list4);


		if (list1.size() > 1) {
			for (int i = 0; i < list1.size(); i++) {
				for (int j = i + 1; i < list1.size(); i++) {
					if (list1.get(j) % list1.get(i) == 0) {
						answer -= 1;
						list1.remove(list1.get(j));
						System.out.println("del"+list1.size());
					}
					if(list1.size()<2) {
						break;
					}
				}
				if(list1.size()<2) {
					break;
				}
			}
		}
		if (list2.size() > 1) {
			for (int i = 0; i < list2.size(); i++) {
				for (int j = i + 1; i < list2.size(); i++) {
					if (list2.get(j) % list2.get(i) == 0) {
						answer -= 1;
						list2.remove(list2.get(i));
						list2.remove(list2.get(j));
					}
					if(list2.size()<2) {
						break;
					}
				}
				if(list2.size()<2) {
					break;
				}
			}
		}
		if (list3.size() > 1) {
			for (int i = 0; i < list3.size(); i++) {
				for (int j = i + 1; i < list4.size(); i++) {
					if (list3.get(j) % list3.get(i) == 0) {
						answer -= 1;
						list3.remove(list3.get(i));
						list3.remove(list3.get(j));
					} 
					if(list3.size()<2) {
						break;
					}
					
				}
				if(list3.size()<2) {
					break;
				}
				
			}
		}
		if (list4.size() > 1) {
			for (int i = 0; i < list4.size(); i++) {
				for (int j = i + 1; i < list4.size(); i++) {
					if (list4.get(j) % list4.get(i) == 0) {
						answer -= 1;
						list4.remove(list4.get(i));
						list4.remove(list4.get(j));
						
					} 
					if(list4.size()<2) {
						break;
					}
				}
				if(list4.size()<2) {
					break;
				}
				
			}
		}

		System.out.println(answer);
		return answer;
	}

}
