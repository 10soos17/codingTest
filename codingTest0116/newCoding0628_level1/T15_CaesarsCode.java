package newCoding0628_level1;

class T15_CaesarsCode {
//	어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
//	예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
//	"z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수,
//
//	제한 조건
//	공백은 아무리 밀어도 공백입니다.
//	s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//	s의 길이는 8000이하입니다.
//	n은 1 이상, 25이하인 자연수입니다.
//	입출력 예
//	s	n	result
//	"AB"	1	"BC"
//	"z"	1	"a"
//	"a B z"	4	"e F d"
	public static void main(String[] args) {
		String n = "a B z";
		int m = 4;
		String res = solution(n, m);

		System.out.println(res);
		// System.out.println(res[0]+":"+res[n.length-2]);

	}

	//답안1
	//더 빠름
	public static String solution(String s, int n) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {

			char cc = s.charAt(i);

			if (("" + s.charAt(i)).equals(" ")) {
				answer += " ";
				continue;
			}

			int c = cc;

			if (65 <= c && c <= 90) {
				c += n;
				if (c > 90)
					c = c % 90 + 64;

			} else {
				c += n;
				if (c > 122)
					c = c % 122 + 96;

			}

			answer += (char) c;

		}

		return answer;
	}

	//답안2
	public static String solution2(String n, int m) {

		String answer = "";

		for (int i = 0; i < n.length(); i++) {
			char s = n.charAt(i);
			int c = s + m;

			if ((s + "").equals(" ")) {
				answer += " ";
				continue;
			} else if (s >= 65 && s <= 90) {
				if (c > 90) {
					c = c % 90 + 64;
					answer += (char) c;
					continue;
				}

			} else {
				if (c > 122) {
					c = c % 122 + 96;
					answer += (char)c;
					continue;
				}
			}

			answer += (char) c;

		}
		return answer;
	}

}