package newCoding0628_level1;

import java.util.Arrays;

public class T32_lottoGradeSort {
	public static void main(String[] args) {
		int n = 5;
		int[] nl = {44, 1, 0, 0, 31, 25};
		int[] ml = {31, 10, 45, 1, 6, 19};
		
		
		String s = "1D2S#10S";
		int[] res = solution(nl, ml);
		System.out.println(res[0]+":"+res[1]);
	}

	public static int[] solution(int[] nl, int[] ml) {
		int[] answer=new int[2];
		
		Arrays.sort(nl);
		Arrays.sort(ml);
		int cnt=0;
		int correct=0;
		for(int i=0;i<6;i++) {
			if(nl[i]==0) {
				cnt++;
				continue;
			}
			for(int j=0;j<6;j++) {
				if(nl[i]==ml[j]) {
					correct++;
					break;
				}
			}
		}
		System.out.println(correct+":"+cnt);
		answer[0] =7-(correct+cnt);
		answer[1] =7-correct;
		if(cnt==6 && correct ==0) {
            answer[0]=1;
            answer[1]=6;
        }
		else if(cnt == 0 && correct ==0) {
			answer[0] = 6;
            answer[1] = 6;
		}
		return answer;
		
	}

}
