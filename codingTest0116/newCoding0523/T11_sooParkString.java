package newCoding0523;

//길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수
//n	return
//3	"수박수"
//4	"수박수박"
public class T11_sooParkString {
	public static void main(String[] args) {
		int n = 4;
		String answer = solution(n);

		System.out.println(answer);

	}

	public static String solution(int n) {
		String answer = "";

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				answer += "수";
				continue;
			}
			answer += "박";
		}

		return answer;
	}
}