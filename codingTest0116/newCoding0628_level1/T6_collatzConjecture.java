package newCoding0628_level1;

class T6_collatzConjecture {
//	주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측
//	
//	1-1. 입력된 수가 짝수라면 2로 나눕니다. 
//	1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
//	2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 
//	주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이
//	위 작업을 몇 번이나 반복해야 하는지 반환하는 함수
//	
//	단, 주어진 수가 1인 경우에는 0을, 
//	작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환
//	
//	n	result
//	6	8
//	16	4
//	626331	-1
	public static void main(String[] args) {
		int n = 626331;
		int res = solution(n);

		System.out.println(res);

	}

	public static int solution(int num) {
		int answer = 0;
		long n = num;
		if(n==1) return 0;
		while(n!=1) {
			if(n%2==0) {
				n/=2;
			}else{
				n=n*3+1;
			}
			answer++;
			if(answer==500) return -1;
		}
		return answer;
	}
}