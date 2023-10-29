package newCoding0628_level1;

class T4_hidePhoneNumber {
//	전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴
//	phone_number	return
//			"01033334444"	"*******4444"
//			"027778888"	"*****8888"
	public static void main(String[] args) {
		String s = "01033334444";
		String res = solution(s);

		System.out.println(res);

	}

	public static String solution(String s) {
		String answer = "";

//1번
//		answer = s.substring(0, s.length() - 4).replaceAll(".", "*");
//		answer += s.substring(s.length() - 4, s.length());

//2번
		answer = s.replaceAll(".(?=.{4})", "*");

		return answer;
	}
}
