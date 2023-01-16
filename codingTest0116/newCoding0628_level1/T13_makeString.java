package newCoding0628_level1;

class T13_makeString {
//	문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
//	각 단어는 하나 이상의 공백문자로 구분
//	각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴
//	
//	문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//	첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리
//	
//	s	return
//	"try hello world"	"TrY HeLlO WoRlD"

	public static void main(String[] args) {
		String s = "try hello world";
		// int m = 5;
		String res = solution(s);

		System.out.println(res);
		// System.out.println(res[0]+":"+res[n.length-2]);

	}

	public static String solution(String n) {

		String answer = "";
		int cnt = 0;

		for (int i = 0; i < n.length(); i++) {
			String text = n.charAt(i) + "";
			if (text == " ") {
				answer += " ";
				cnt = 0;
				continue;
			}
			if (cnt % 2 == 0 || cnt == 0) {
				answer += text.toUpperCase();
				cnt++;
				continue;
			}
			answer += text.toLowerCase();
			cnt++;
		}

		return answer;
	}

}