package newCoding0628_level1;

class T5_harshadNum {
//	양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
//	양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
//	예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
//	자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수
//	arr	return
//			10	true
//			12	true
//			11	false
//			13	false

	public static void main(String[] args) {
		int n = 13;
		boolean res = solution(n);

		System.out.println(res);

	}

	public static boolean solution(int n) {
		boolean answer = false;
		int m = n;
		int sum=0;
		while(m>0) {
			sum+=m%10;
			m/=10;
		}
		if(n%sum==0) return true;

		return answer;
	}
}