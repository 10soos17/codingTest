package newCoding0523;

//정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴
//n	return
//12	28
//5	6

public class T1_plusSubmultiple {
	public static void main(String[] args) {
		int n = 9;
		int answer = solution(n);
		System.out.println(answer);
		
		answer = solution2(n);
		System.out.println(answer);
	}

	public static int solution(int n) {
		int answer=0;
		
		int point = (int)Math.sqrt(n);
		
		if(n == 1) return 1;
		while(point > 0) {
			if(n%point !=0) {
				point--;
				continue;
			}
			
			if(point==n/point) {
				answer+=point;
				point--;
				continue;
			}
			
			answer+=point;
			answer+=(n/point);
			point--;
		}

		
		return answer;
	}
	
	public static int solution2(int n) {
		int answer=0;
		

		
		if(n == 1) return 1;
		if(n%Math.sqrt(n)==0) answer+=Math.sqrt(n);
		
		int point = (int)Math.sqrt(n)-1;
		while(point > 0) {
			if(n%point !=0) {
				point--;
				continue;
			}
			
			answer+=point;
			answer+=(n/point);
			point--;
		}

		
		return answer;
	}
}
