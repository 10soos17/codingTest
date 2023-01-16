package newCoding0628_level1;

import java.util.Arrays;

class T8_removeSmallestNum {
//	정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴
//	단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴
//	arr	return
//	[4,3,2,1]	[4,3,2]
//	[10]	[-1]
	public static void main(String[] args) {
		int[] n = {4,3,2,1};
		//int m = 5;
		int[] res = solution(n);

		System.out.println(res[0]+":"+res[n.length-2]);

	}

	public static int[] solution(int[] n) {
		
		if(n.length==1) return new int[] {-1};
		
		int[] answer=new int[n.length-1];
		int[] c = n.clone();
		Arrays.sort(c);
		int min = c[0];
		int cnt=0;
		
		for(int i=0;i<n.length;i++) {
			if(n[i]==min)continue;
			answer[cnt]=n[i];
			cnt++;
		}
		
		return answer;
	}
}