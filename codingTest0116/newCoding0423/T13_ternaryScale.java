package newCoding0423;


class T13_ternaryScale {
//	1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return
//    b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
//			
//    a	b	result
//    [1,2,3,4]	[-3,-1,0,2]	3 a와 b의 내적은 1*(-3) + 2*(-1) + 3*0 + 4*2 = 3
//    [-1,0,1]	[1,0,-1]	-2
	
	public static void main(String[] args) {
		int[] a= {1,2,3,4};
		int[] b= {-3,-1,0,2};
		int res = solution(a,b);
		System.out.println("res:"+res);
	}

	public static int solution(int[] a, int[] b) {
		int answer=0;
		for(int i=0;i<a.length;i++) {
			answer+=a[i]*b[i];
		}
		
		return answer;
	}
}