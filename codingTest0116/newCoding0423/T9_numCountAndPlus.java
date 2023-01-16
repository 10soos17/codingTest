package newCoding0423;


class T9_numCountAndPlus {
//	left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return
//	left	right	result
//	13	17	43
//	24	27	52
//	===
//	수	약수	약수의 개수
//	13	1, 13	2
//	14	1, 2, 7, 14	4
//	15	1, 3, 5, 15	4
//	16	1, 2, 4, 8, 16	5
//	17	1, 17	2
//	==========
//	13 + 14 + 15 - 16 + 17 = 43을 return 해야 합니다.
	
	public static void main(String[] args) {
		int left=13;
		int right=17;
		int res = solution(left,right);
		System.out.println("res:"+res);
	}

	public static int solution(int left, int right) {
		
		int answer=0;
		
		while(left<=right) {
			System.out.println(left+":loop");
			if(check(left)) {
				answer+=left;
				left++;
				continue;
				}
			answer-=left;
			left++;
		}
		
		return answer;
	}
	
	public static boolean check(int num) {
		if(num%Math.sqrt(num)==0) {
			System.out.println(num);
			return false;
		}
		return true;
	}
}