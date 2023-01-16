package newCoding0628_level1;

import java.util.Arrays;

//당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 
//최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다. 
//N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, 
//N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 
//그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
//		nums	result
//		[3,1,2,3]	2
//		[3,3,3,2,2,4]	3
//		[3,3,3,2,2,2]	2
public class T29_phoneKetMon{
	
	public static void main(String[] args) {
		int nl[] = {3,3,3,2,2,4};
		int n = 5;
		int m = 24;
		int res = solution(nl);
		System.out.println(res);
		
	}

	public static int solution(int[] nl) {
		int answer=1;
		int limit = nl.length/2;
		
		Arrays.sort(nl);
		
		for(int i=1;i<nl.length;i++) {
			if(answer >= limit) return answer;
			if(nl[i]!=nl[i-1]) answer+=1;
			
		}
		
		return answer;
	}
	
}







