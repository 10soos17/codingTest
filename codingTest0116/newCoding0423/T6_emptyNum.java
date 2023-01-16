package newCoding0423;

class T6_emptyNum {
//	1 ≤ numbers의 길이 ≤ 9
//	0 ≤ numbers의 모든 원소 ≤ 9
//	numbers의 모든 원소는 서로 다릅니다.
//	numbers	result
//	[1,2,3,4,6,7,8,0]	14
	static int res;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 6, 7, 8, 0 };
		res = 0;
		solution(nums);
		System.out.println(res);
	}

	public static int solution(int[] numbers) {
		boolean[] check = new boolean[10];
		for (int i = 0; i < numbers.length; i++) {
			check[numbers[i]] = true;
		}
		for (int i = 0; i < check.length; i++) {
			if (!check[i]) {
				res += i;
				System.out.println("check:" + i);
			}
		}
		return res;

	}

}