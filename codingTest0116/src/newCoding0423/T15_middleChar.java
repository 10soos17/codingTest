package newCoding0423;


class T15_middleChar {
//단어 s의 가운데 글자를 반환 / 단어의 길이가 짝수라면 가운데 두글자를 반환
//			s	return
//			"abcde"	"c"
//			"qwer"	"we"

	public static void main(String[] args) {
		String s ="abcd";
		String res = solution(s);
		System.out.println("res:"+res);

		res = solution2(s);
		System.out.println("res:"+res);
	}

	public static String solution(String s) {
		String answer="";
		int len = s.length();
		if(len%2 ==0){
			answer+=s.charAt((len/2)-1)+""+s.charAt(len/2);
			return answer;
		}
		answer=s.charAt(len/2)+"";
		return answer;
	}

	public static String solution2(String s) {


		 return s.substring((s.length()-1) / 2, s.length()/2 + 1);
	}
}