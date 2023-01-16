package newCoding0628_level1;

class T17_sooParkPattern {
//	 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
//
//	 제한 조건
//	 n은 길이 10,000이하인 자연수입니다.
//	 입출력 예
//	 n	return
//	 3	"수박수"
//	 4	"수박수박"
	public static void main(String[] args) {
		int n = 3;
		// nt m = 4;
		String res = solution(n);

		System.out.println(res);
		// System.out.println(res[0]+":"+res[n.length-2]);

	}

	// 답안1
	// 더 빠름
	public static String solution(int s) {
		String answer = "";

		for (int i = 0; i <s; i++) {
			if (i % 2 == 0) {
				answer += "수";
				continue;
			}
			answer += "박";
		}

		return answer;

	}

}