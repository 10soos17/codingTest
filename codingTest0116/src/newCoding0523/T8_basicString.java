package newCoding0523;

//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수
//s	return
//"a234"	false
//"1234"	true

public class T8_basicString {
	public static void main(String[] args) {
		String s = "+234";
		boolean answer = solution(s);
		System.out.println(answer);

	}

	public static boolean solution(String s) {
		boolean answer = false;

		if (("" + s.charAt(0)).equals("+") || ("" + s.charAt(0)).equals("-")) {
			return answer;
		}

		try {
			Integer.parseInt(s);
			if (s.length() == 4 || s.length() == 6) {
				return true;
			} else {
				return answer;
			}
		} catch (Exception e) {
			return answer;
			// }
		}
	}
}

//if (s.length() == 4 || s.length() == 6) {
//	try {
//		Integer.parseInt(s);
//		return true;
//	} catch (Exception e) {
//		return false;
//	}
//} else {
//	return answer;
//}
