package coding_naver;

import java.util.ArrayList;
import java.util.Scanner;

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
public class Test1 {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int n = 10;// scanner.nextInt(); // 송수신 기록의 수
		// String[] logs = new String[n]; // 송수신 기록

//		for(int i = 0 ; i < n ; i ++)
//		{
//			logs[i] = scanner.nextLine().trim();
//		}
//
		String[] logs = { "SMS 010-1234-5678", "CALL 010-1234-5678", "CALL 010-1234-5678", "SMS 010-1111-1111",
				"SMS 010-5555-5555", "CALL 010-5555-5555", "CALL 010-5555-5555", "CALL 010-4444-4444",
				"SMS 010-5555-5555", "CALL 010-5555-5555" };

		solution(logs, n);
	}

	public static void solution(String[] logs, int n) {

		ArrayList<String> answer = new ArrayList<>();
		int cnt = 1;
		int num = 0;

		for (int i = num; i < logs.length; i++) {
			if(num == logs.length-1) {
				answer.add(logs[num]);
				break;
			}else{

		for (int j = num + 1; j < logs.length; j++) {

			if (logs[num].equals(logs[j])) {
				cnt += 1;
			} else {

				if (cnt == 1) {

					answer.add(logs[num]);
					num = j;
					break;
				}
				else if (cnt != 1) {

					String res = logs[num];
					res += " (" + cnt + ")";
					answer.add(res);

					num = j;
					cnt = 1;

					break;

				}
			}

		}
			}
	}

		System.out.println(answer.size());
		for (String s : answer) {
			System.out.println(s);
		}

	}

}
