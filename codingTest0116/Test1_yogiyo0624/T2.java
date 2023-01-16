package Test1_yogiyo0624;

import java.util.Arrays;

public class T2 {

	public static void main(String[] args) {
		int n[] = {6,2,3,5,6,3};

		int res = solution(n);

		System.out.println(res);
		
	}

	public static int solution(int[] n) {
		int answer = 0;

		Arrays.sort(n);
		if(n[0]!=1) {
			answer++;
			n[0] = 1;
		}
		for(int i=1;i<n.length;i++) {
			if(n[i]-n[i-1]==0) {
				n[i]+=1;
				answer++;
			}
			else if(n[i]-n[i-1]>1) {
				n[i]-=1;
				answer++;
			}
	
		}
		
		return answer;
	}

}