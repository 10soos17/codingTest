package newCoding0523;

//정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴
//x	n	answer
//2	5	[2,4,6,8,10]
//4	3	[4,8,12]
//-4	2	[-4, -8]
public class T6_intervalNums {
	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		long[] answer = solution(x, n);
		for (long l : answer) {
			System.out.println(l);
		}
	}

//(long) 형변환 해줘야 함
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];

		while (n > 0) {

			// (long) 형변환 해줘야 함
			answer[n - 1] = (long) n * x;
			n--;
		}

		return answer;
	}

}
