package newCoding0628_level1;

class T19_searchKim {
//	String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아,
//	"김서방은 x에 있다"는 String을 반환
//
//	seoul	return
//	["Jane", "Kim"]	"김서방은 1에 있다"

	public static void main(String[] args) {

		String[] n = { "Jane", "Kim" };

		String res = solution(n);

		System.out.println(res);

	}

	public static String solution(String[] n) {
		int idx = 0;

		for (int i = 0; i < n.length; i++) {
			if (n[i].equals("Kim")) {
				idx = i;
				break;
			}
		}

		String answer = "김서방은 " + idx + "에 있다";

		return answer;
	}

}