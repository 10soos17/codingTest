package newCoding0628_level1;
//두 정수 left와 right가 매개변수로 주어집니다.
//left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
//약수의 개수가 홀수인 수는 뺀 수를
//return 하도록 solution 함수를 완성해주세요.
class T27_checkSubmultiple {

	public static void main(String[] args) {

		int n = 24;
		int m = 27;


		int res = solution(n,m);

		System.out.println(res);

	}

	public static int solution(int n, int m) {

		int answer=0;

		int min = Math.min(n,m);
		int max = Math.max(n,m);

		while(min<=max) {
			if(check(min)) answer+=min;
			else answer-=min;
			min++;
		}
		return answer;


	}

	public static boolean check(int n) {

		//if(n==1) return false;
		if(n%(Math.sqrt(n))==0) return false;
		return true;

	}
}