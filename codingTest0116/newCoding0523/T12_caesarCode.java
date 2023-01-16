package newCoding0523;

//각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
//예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 
//3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 
//문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수
//s는 알파벳 소문자, 대문자, 공백으로만
//s	n	result
//"AB"	1	"BC"
//"z"	1	"a"
//"a B z"	4	"e F d"
public class T12_caesarCode {
	public static void main(String[] args) {
		String s = "a B z";
		int n = 4;
		String answer = solution(s, n);

		System.out.println(answer);

	}

	public static String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			
			char cc = s.charAt(i);
			
			if (("" + s.charAt(i)).equals(" ")) {
				answer += " ";
				continue;
			}

			int c = (int) cc;

			if (65 <= c && c <= 90) {
				c += n;
				if (c > 90) c = c% 90 + 64;

			} else {
				c += n;
				if (c> 122) c = c % 122 + 96;

			}

			answer += (char) c;
			

		}

		return answer;

	}
	public static String solution2(String n, int num) {

		String answer = "";

		for (int i = 0; i < n.length(); i++) {

			int c = n.charAt(i) + num;

			if ((n.charAt(i) + "").equals(" ")) {
				answer += " ";
				// System.out.println(1);
			} else if (97 > c && c > 90) {
				// int gap = c - 90;
				answer += (char) (64 + c - 90);
				// System.out.println(2);
			} else if (c > 122) {
				// int gap = c - 122;
				answer += (char) (96 + c - 122);
				// System.out.println(3);
			} else {
				answer += (char) c;
				// System.out.println(4);
			}

		}

		return answer;
	}
}