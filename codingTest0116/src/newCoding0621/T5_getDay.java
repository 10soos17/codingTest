package newCoding0621;

import java.time.LocalDate;

//2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
//두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수
//요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
//예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환
//2016년은 윤년입니다.
//2016년 a월 b일은 실제로 있는 날입니다.
//(13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
//
//a	b	result
//5	24	"TUE"
public class T5_getDay {
	public static void main(String[] args) {

		int a = 5;
		int b = 24;
		String answer = solution(a, b);

			System.out.println(answer);

	}

	public static String solution(int n, int m) {
		String answer = "";

		answer = LocalDate.of(2016, n, m).getDayOfWeek().toString().substring(0,3);

		return answer;
	}
}
