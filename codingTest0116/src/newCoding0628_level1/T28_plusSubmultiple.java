package newCoding0628_level1;

class T28_plusSubmultiple {

	public static void main(String[] args) {

		int n = 12;

		int res = solution(n);

		System.out.println(res);

	}

	public static int solution(int num) {

		int answer = 0;
		int limit = num;

		if (num == 1) return 1;
		if (num % Math.sqrt(num) == 0) answer += Math.sqrt(num);

		while (limit > Math.sqrt(num)) {
			if (num % limit == 0) {
				answer += limit;
				System.out.println(limit + ":" + answer);
				answer += num / limit;
				System.out.println(":" + answer);
			}
			limit -= 1;
		}
		return answer;
	}
}