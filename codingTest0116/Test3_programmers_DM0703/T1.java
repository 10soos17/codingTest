package Test3_programmers_DM0703;

public class T1 {

	public static void main(String[] args) {
		int[] n = {3,2,3,6,4,3};

		int res = solution(n);
		System.out.println(res);

	
	}

	public static int solution(int[] n) {

		int answer = 0;
		
		for(int i=n.length-1;i>0;i--) {
			if(n[i-1]>n[i]) {
				int gap = n[i-1]-n[i];
				n[i-1]-=gap;
				answer+=gap;
				
			}
		}

		return answer;
	}



}