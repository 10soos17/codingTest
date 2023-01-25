package newCoding0523;

//전화번호가 문자열 phone_number로 주어졌을 때,
//전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수
//phone_number	return
//"01033334444"	"*******4444"
//"027778888"	"*****8888"
public class T14_hideNumber {
	public static void main(String[] args) {

		String phone_number = "01033334444";

		String answer = solution(phone_number);
		System.out.println(answer);

		answer = solution2(phone_number);
		System.out.println(answer);

		answer = solution3(phone_number);
		System.out.println(answer);

	}

	public static String solution(String phone_number) {
		String answer = "";

//        answer+=phone_number.substring(0,phone_number.length()-4);
//        phone_number=phone_number.substring(phone_number.length()-4,phone_number.length());
//
		for (int i = 0; i < phone_number.length(); i++) {
			if (i >= phone_number.length() - 4) {

				answer += phone_number.charAt(i);

				continue;
			}
			answer += "*";
		}

		System.out.println(answer);
		return answer;
	}

	// substring & 정규표현
	public static String solution2(String phone_number) {

		return phone_number.replaceAll(".(?=.{4})", "*");

	}

	public static String solution3(String phone_number) {
		String answer = phone_number.substring(0, phone_number.length() - 4).replaceAll(".", "*")
				+ phone_number.substring(phone_number.length() - 4);

		// 0103333 -> ******* -> *******4444
		return answer;
	}
}
