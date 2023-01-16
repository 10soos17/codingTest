package newCoding0423;

import java.util.ArrayList;
import java.util.LinkedHashSet;

class T7_removeNum {
//	배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
//	[1,1,3,3,0,1,1]	[1,3,0,1]
//  [4,4,4,3,3]	[4,3]

	public static void main(String[] args) {
		int[] nums = { 1, 3,3, 0, 0,0,1 };
		ArrayList<Integer> s = solution(nums);
		for (int t : s) {
			System.out.println(t);
		}
	}

	public static ArrayList<Integer> solution(int[] numbers) {
		ArrayList<Integer> s = new ArrayList<>();
		int idx = 0;
		int idxx = 1;

		while (idxx < numbers.length) {
			if (numbers[idx] != numbers[idxx]) {
				s.add(numbers[idx]);
				idx = idxx;
			}
			idxx++;
		}
		s.add(numbers[idxx-1]);
		
		return s;

	}
	

}