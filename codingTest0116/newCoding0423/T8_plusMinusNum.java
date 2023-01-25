package newCoding0423;


class T8_plusMinusNum {
//	absolutes	signs	result
//	[4,7,12]	[true,false,true]	9
//	[1,2,3]	[false,false,true]	0

	public static void main(String[] args) {
		int[] nums = {4,7,12};
		boolean[] signs = {true,false,true};
		int res = solution(nums,signs);
		System.out.println(res);
	}

	public static int solution(int[] absolutes, boolean[] signs) {
		int answer=0;

		for(int i=0;i<signs.length;i++) {
			if(!signs[i]) {
				answer-=absolutes[i];
				continue;
			}
			answer+=absolutes[i];

		}

		return answer;
	}

	//프로그래머스 다른 풀이
	public static int solution2(int[] absolutes, boolean[] signs) {
		int answer=0;
		for (int i=0; i<signs.length; i++)
            answer += absolutes[i] * (signs[i]? 1: -1);
		return answer;
	}

	//프로그래머스 다른 풀이
	public static int solution3(int[] absolutes, boolean[] signs) {
		int answer=0;
		 for (int i = 0; i < absolutes.length; i++) {
	            answer += (signs[i]) ? absolutes[i] : -absolutes[i];
	        }
		return answer;
	}
}