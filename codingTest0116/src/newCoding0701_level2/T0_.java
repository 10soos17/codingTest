package newCoding0701_level2;

//"aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)
//예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만,
//2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다.
//다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법
//압축할 문자열 s가 매개변수
//
//s	result
//"aabbaccc"	7
//"ababcdcdababcdcd"	9
//"abcabcdede"	8
//"abcabcabcabcdededededede"	14
//"xababcdcdababcdcd"	17https://ananti.kr/ko/reservation/ganm/room-search?memNo=5038910400&regType=RR&roomRateCd=undefined

public class T0_ {

	public static void main(String[] args) {
		String n = "aabbaccc";
		int answer = solution(n);
		System.out.println(answer);
	}

	//프로그래머스 풀이
	public static int solution(String s) {
		int answer=0;

		for(int i=1;i<=s.length()/2+1;i++) {
			int result = getSplitedLen(s,i,1).length();
			answer = i==1 ? result : (answer>result?result:answer);
		}

	return answer;
}
	public static String getSplitedLen(String s, int n, int repeat) {
		if(s.length() < n) return s;
		String result = "";
		String preString = s.substring(0,n);
		String postString = s.substring(n, s.length());


		if(!postString.startsWith(preString)) {

			if(repeat ==1) return preString + getSplitedLen(postString, n, 1);
			return result+=Integer.toString(repeat) + preString + getSplitedLen(postString, n, 1);
		}

		return result +=getSplitedLen(postString, n, repeat+1);
	}

}
