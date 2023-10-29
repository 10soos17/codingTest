package newCoding0523;

//N	answer
//123	6
//987	24

public class T2_plusPositionalNum {
	public static void main(String[] args) {
		int n = 123;
		int answer = solution(n);
		System.out.println(answer);

	}

	public static int solution(int n) {
		int answer=0;

		String[] num = String.valueOf(n).split("");

		for(String s : num) {
			answer+=Integer.parseInt(s);
		}


		return answer;
	}

	//프로그래머스풀이
	public static int solution2(int n) {
		int answer=0;

	       while(true){
	            answer+=n%10;
	            if(n<10)
	                break;

	            n=n/10;
	        }

	       return answer;
	}

}
