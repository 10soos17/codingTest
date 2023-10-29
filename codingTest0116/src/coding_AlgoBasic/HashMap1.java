package coding_AlgoBasic;

import java.util.HashMap;

//https://www.youtube.com/watch?v=y-0DZ1MFN1g&list=PLDV-cCQnUlIYjwJ_b-f8Z0OQlIqKpMkDr&index=2
//문제: 양수로 주어진 nums중에서 두 수의 합이 target이 되는 index들을 return하여라
public class HashMap1 {

	public static void main(String[] args) {

		int[] arr = { 13, 7, 5, 1, 3, 2, 8 };
		int target = 10;
		solution(arr, target);

	}

	public static void solution(int[] arr, int target) {

		HashMap<Integer, Integer> map = new HashMap<>();
		//ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();//값 얻기


		for (int i = 0; i < arr.length; i++) {

			int num = target - arr[i];

			if (map.get(num) != null) {// 합이 10인 값이 배열에 있는 경우
//				ArrayList<Integer> list2 = new ArrayList<>();

				System.out.println(i + ":" + map.get(num));//인덱스번호 얻기

//				list2.add(arr[i]);
//				list2.add(num);
//				list1.add(list2);

			}
			map.put(arr[i], i);

		}

//		for (int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i));
//		}

	}
}
