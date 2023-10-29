package newCoding0628_level1;

class T20_checkString {
//	문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수
//	예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴
//
//	s	return
//	"a234"	false
//	"1234"	true
	public static void main(String[] args) {

		String n = "-234";

		boolean res = solution(n);

		System.out.println(res);

	}

	public static boolean solution(String s) {
		boolean answer = false;

		if (s.length() == 4 || s.length() == 6) {
			try {
				Integer.parseInt(s);

				if ((s.charAt(0) + "").equals("0") ||(s.charAt(0) + "").equals("+") || (s.charAt(0) + "").equals("-")) {
					return true;
				}
			} catch (Exception e) {
				return answer;
			}
		}

		return answer;
	}

}