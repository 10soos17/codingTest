package newCoding0628_level1;

class T16_stringToNum {
//	문자열 s를 숫자로 변환한 결과를 반환하는 함수
//	제한 조건
//	s의 길이는 1 이상 5이하입니다.
//	s의 맨앞에는 부호(+, -)가 올 수 있습니다.
//	s는 부호와 숫자로만 이루어져있습니다.
//	s는 "0"으로 시작하지 않습니다.
//	입출력 예
//	예를들어 str 이 "1234"이면 1234를 반환하고, "-1234"이면 -1234를 반환하면 됩니다.
//	str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.
	public static void main(String[] args) {
		String n = "+1234";
		//nt m = 4;
		int res = solution(n);

		System.out.println(res);
		// System.out.println(res[0]+":"+res[n.length-2]);

	}

	//답안1
	//더 빠름
	public static int solution(String s) {
		int answer = 0;
		String i = s.charAt(0)+"";
		if(i.equals("+")) {
			return Integer.parseInt(s.substring(1, s.length()));
		}
		answer = Integer.parseInt(s);

		return answer;

	}



}