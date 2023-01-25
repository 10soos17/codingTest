package Test1_yogiyo0624;

public class T1 {

	public static void main(String[] args) {
		int n = 125;

		int res = solution(n);

		System.out.println(res);

	}

	public static int solution(int N) {

		int answer =0;
		if(N==1) return answer;

		String s = String.valueOf(N);
		answer = (int)Math.pow(10,s.length()-1);


		return answer;
	}

}