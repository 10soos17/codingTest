package codingTest_pro;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	static int check;
	public static void main(String[] args) {


		/*
		 * 문제 설명
A카드사 홈페이지에 가입된 아이디들은 다음과 같은 형태를 갖추고 있습니다.

모든 아이디는 S+N 형식입니다.
S는 알파벳 소문자(a ~ z)로 구성된 문자열로 길이는 3 이상 6 이하입니다.
N는 숫자(0~9)로 구성된 문자열로 길이는 0 이상 6 이하입니다.
N의 길이가 0이 될 수도 있다는 것은, N이 비어있는 널(null) 문자열이 될 수도 있다는 의미입니다.
N의 길이가 1 이상이면, N의 첫자리는 "0"이 될 수 없습니다.
즉, "034" , "06", "0", "09040", "000"과 같은 문자열은 N이 될 수 없습니다.
위의 규칙에 부합하는, 올바른 아이디의 예를 들어보면 다음과 같습니다.
"ace", "hahaa512", "sunfri1", "aaaaaa900000", "abcde10101"

위의 규칙에 위배되는, 잘못된 아이디의 예를 들어보면 다음과 같습니다.

아이디	부적합 사유
"ac"	S의 길이가 3 미만입니다.
"Ange1004"	S에 알파벳 소문자가 아닌 문자가 포함되어 있습니다.
"1004angel"	S+N 형식이 아닙니다.(N+S형식은 허용하지 않습니다.)
"aaaaa1aaaaa"	S+N 형식이 아닙니다.(S+N+S 형식은 허용하지 않습니다.)
"triger0145"	N의 첫자리가 "0"이 될 수 없습니다.
"abcdefg733"	S의 길이가 6을 초과합니다.
"zzzzz4954951"	N의 길이가 6을 초과합니다.
이미 홈페이지에 가입된 아이디들의 목록(registered_list)과, 신규회원이 사용하기를 원하는 아이디(new_id)가 있다면, 아래와 같은 방법으로 신규회원에게 아이디를 추천해주려고 합니다.

new_id가 registered_list에 포함되어 있지 않다면, new_id를 추천하고 종료합니다.
new_id가 registered_list에 포함되어 있다면,

2-1. new_id를 두 개의 문자열 S와 N으로 분리합니다.
2-2. 문자열 N을 10진수 숫자로 변환한 값을 n이라고 합니다.(단, N이 비어있는 null 문자열이라면, n은 0이 됩니다.)
2-3. n에 1을 더한 값(n+1)을 문자열로 변환한 값을 N1라고 합니다.
2-4. new_id를 S+N1로 변경하고 1.로 돌아갑니다.

이미 가입된 아이디들의 목록 registered_list와 신규회원이 사용하기를 원하는 아이디 new_id가 매개변수로 주어집니다. 이때 설명한 방법을 적용했을 때, 신규회원에게 추천되는 아이디를 return 하도록 solution 함수를 완성해주세요.

제한사항
new_id는 올바른 S+N 형식의 아이디(문자열)입니다.
registered_list는 길이가 1 이상 100,000 이하인 문자열 배열입니다.
registered_list의 각 원소는 올바른 S+N 형식의 아이디(문자열)입니다.
registered_list에 중복된 원소는 없습니다.(즉, 모두 서로 다른 아이디입니다.)
문제에서 설명된 방법을 적용하여 return 되는 추천 아이디는 항상 올바른 S+N 형식임이 보장됩니다.
즉, 추천 아이디를 결정하는 방법을 수행하면서 N 부분의 자릿수가 6을 초과하는 경우의 입력은 주어지지 않습니다.
입출력 예
registered_list	new_id	result
["card", "ace13", "ace16", "banker", "ace17", "ace14"]	"ace15"	"ace15"
["cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"]	"cow"	"cow10"
["bird99", "bird98", "bird101", "gotoxy"]	"bird98"	"bird100"
["apple1", "orange", "banana3"]	"apple"	"apple"
입출력 예 설명
입출력 예 #1
registered_list에 new_id("ace15")가 포함되지 않았으므로, "ace15"가 추천 아이디입니다.

입출력 예 #2
registered_list에 new_id("cow")가 포함되어 있으므로, 다음과 같이 new_id를 바꾸는 과정을 거칩니다.
"cow" ⇒ "cow1" ⇒ "cow2" ⇒ "cow3" ⇒ "cow4" ⇒ "cow5" ⇒ "cow6" ⇒ "cow7" ⇒ "cow8" ⇒ "cow9" ⇒ "cow10"
"cow10"은 registered_list에 포함되지 않았으므로, "cow10"가 추천 아이디입니다.

입출력 예 #3
registered_list에 new_id("bird98")가 포함되어 있으므로, 다음과 같이 new_id를 바꾸는 과정을 거칩니다.
"bird98" ⇒ "bird99" ⇒ "bird100"
"bird100"은 registered_list에 포함되지 않았으므로, "bird100"가 추천 아이디입니다.

입출력 예 #4
registered_list에 new_id("apple")가 포함되지 않았으므로, "apple"가 추천 아이디입니다.
		 * ["card", "ace13", "ace16", "banker", "ace17", "ace14"]	"ace15"	"ace15"
["cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"]	"cow"	"cow10"
["bird99", "bird98", "bird101", "gotoxy"]	"bird98"	"bird100"
["apple1", "orange", "banana3"]	"apple"	"apple"
		 */

		String[] arr = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
		String s = "cow";
		// [3, 30, 34, 5, 9] "9534330"

		solution(arr, s);

	}

	public static String solution(String[] rList, String new_id) {
		String answer = new_id;

		ArrayList<String> l = new ArrayList<>();
		for (String element : rList) {
			l.add(element);
		}
		check= l.indexOf(answer);
		while(check != -1) {
					String reg = "[1-9]{0,6}$";
					Pattern p = Pattern.compile(reg);
					Matcher m =p.matcher(answer);
					m.find();

					System.out.println("test");
					System.out.println("1"+m.group(0));

					String tmp = m.group(0);

					reg = "^[a-z]{3,6}";
					p = Pattern.compile(reg);
					m =p.matcher(answer);
					m.find();
					System.out.println("2"+m.group(0));

					int n=0;
					if(tmp =="") {
						n=1;
					}else {
						n = Integer.parseInt(tmp)+1;
					}

					l.remove(answer);
					answer=m.group(0)+n;
					check = l.indexOf(answer);
			}

		System.out.println(answer);
		return answer;
	}

}
