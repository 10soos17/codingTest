package newCoding0423;

class T12_innerProduct {
//	n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return
//			n	result
//			45	7
//			125	229
//			n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
//			45	1200	0021	7
	public static void main(String[] args) {
		int a = 125;// 45;

		int res = solution(a);
		System.out.println("res:" + res);

		res = solution2(a);
		System.out.println("res:" + res);
	}

	public static int solution(int a) {
		int answer = 0;
		String t = "";
		while (a > 0) {
			t += a % 3;
			a = a / 3;
		}

//		while(a>=3) {
//			t+=a%3;
//			a/=3;
//		}
//		t+=a;

		System.out.println(t);
		for (int i = 0; i < t.length(); i++) {
			answer += Integer.parseInt(t.charAt(i) + "") * Math.pow(3, t.length() - i - 1);
		}

		return answer;
	}

	// 프로그래머스 풀이
	public static int solution2(int n) {
		String a = "";

		while (n > 0) {
			a = a+(n % 3);
			n /= 3;
		}
	//	a = new StringBuilder(a).reverse().toString();

		return Integer.parseInt(a, 3);
	}

}