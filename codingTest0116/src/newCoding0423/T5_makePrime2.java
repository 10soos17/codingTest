package newCoding0423;
//for문으로 구현
class T5_makePrime2 {

	static int[] nums = { 1, 2, 7, 6, 4 };
	static int res;

	public static void main(String[] args) {

		res = 0;

		if (3 > nums.length || nums.length > 50) {
			System.out.println(res);
		}

		solution();
		System.out.println("res:" + res);

	}

	public static int solution() {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (check(sum))res++;
				}
			}
		}
		return res;

	}

	public static boolean check(int num) {
		if (num % 2 == 0)
			return false;

		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}