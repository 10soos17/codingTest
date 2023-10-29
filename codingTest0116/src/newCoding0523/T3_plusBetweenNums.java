package newCoding0523;

//a	b	return
//3	5	12
//3	3	3
//5	3	12

public class T3_plusBetweenNums {
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		long answer = solution(n, m);
		System.out.println(answer);

	}

	public static long solution(int a, int b) {
		long answer = 0;
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		//if(min == max) return a;
		while(min<=max) {
			answer+=min;
			min+=1;
		}

		return answer;
	}

}
