package newCoding0628_level1;


class T2_intervalNumber {
//	정수 x와 자연수 n을 입력 받아, 
//	x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴
//	x	n	answer
//	2	5	[2,4,6,8,10]
//	4	3	[4,8,12]
//	-4	2	[-4, -8]
	public static void main(String[] args) {
		int n=4;
		int m=3;
		int[] res =solution(n,m);
		for(int i : res) {
			System.out.println(i);
			
		}
	}

	public static int[] solution(int n, int m) {
		int[] answer=new int[m];

		while(m>0) {
			answer[m-1] = m*n;
			m--;
		}
	
		
		return answer;
	}
}