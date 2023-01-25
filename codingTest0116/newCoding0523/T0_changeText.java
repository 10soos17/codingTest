package newCoding0523;

//s	return
//"try hello world"	"TrY HeLlO WoRlD"
//문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

public class T0_changeText {
	public static void main(String[] args) {
		String text = " try hello world a !,, ";

		String answer = solution(text);
		System.out.println(answer);
	}

	public static String solution(String text) {
		String answer = "";
		int count = 0;

		for (int i = 0; i < text.length(); i++) {

			String t = "" + text.charAt(i);

			if(t.equals(" ")) {
				//System.out.println(t);
				answer+= " ";
				count = 0;
				continue;
			}

			if (count % 2 != 0) {
				answer += t.toUpperCase();
				count++;
				continue;

			}
			answer += t.toLowerCase();
			count++;

		}
		return answer;
	}
}
