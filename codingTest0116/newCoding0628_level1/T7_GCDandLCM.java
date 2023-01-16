package newCoding0628_level1;

class T7_GCDandLCM {
//	두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환
//	두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환
//	 n	m	return
//	 3	12	[3, 12]
//	 2	5	[1, 10]	 
	public static void main(String[] args) {
		int n =2;
		int m = 5;
		int[] res = solution(n, m);

		System.out.println(res[0]+":"+res[1]);

	}

	public static int[] solution(int n, int m) {
		int[] answer=new int[2];
		
		int min = Math.min(n, m);
		
		while(min>0) {
			if(n%min==0 && m%min == 0) {
				answer[0]=min;
				if(answer[0]==1) {
					answer[1] = n*m;
				}else {
					answer[1] = n*m / answer[0];
				}
				break;
			}
			min--;
		}

		return answer;
	}
}