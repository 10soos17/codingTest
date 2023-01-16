package newCoding0423;


class T14_remainderOne {
//	자연수 n이 매개변수로 주어집니다. 
//	n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return
//			n	result
//			10	3
//			12	11
	
	public static void main(String[] args) {
		int n = 10;
		int res = solution(n);
		System.out.println("res:"+res);
	}

	public static int solution(int n) {
		
		int answer=n-1;
		int i=(int)Math.sqrt(n-1)+1;
		
		while(i>1) {
			
			if((n-1)%i==0) {
				System.out.println("n:"+i);
				answer=i;
			}
			i--;
		}
		
		return answer;
	}
}