package newCoding0621;

//String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아,
//"김서방은 x에 있다"는 String을 반환하는 함수,
//seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
//
//seoul	return
//["Jane", "Kim"]	"김서방은 1에 있다"
public class T1_SearchKim {
	public static void main(String[] args) {
		String[] n = { "Jane", "Kim" };
		String answer = solution(n);
		System.out.println(answer);
	}

	public static String solution(String[] n) {

		for (int i = 0; i < n.length; i++) {
			if (n[i].equals("Kim")) {

				return "김서방은 " + i + "에 있다";
			}
		}

		return "";
	}
}
//문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
//각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
//예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면
//각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//strings	n	return
//["sun", "bed", "car"]	1	["car", "bed", "sun"]
//["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
