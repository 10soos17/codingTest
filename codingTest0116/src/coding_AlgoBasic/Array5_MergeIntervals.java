package coding_AlgoBasic;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=S9eQ6DIBPqg&list=PLDV-cCQnUlIYFOXYzqLoXnEye4WxDa_30&index=9
//시간복잡도: o(n^2) or 정렬(o(n)) 후 병합 경우는: (o(n*logn) -> o(n*logn)
//공간복잡도:
public class Array5_MergeIntervals {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);

		int[][] arr1 = { { 3, 5, 6, 7 }, { 8, 10, 13, 16 }, { 10, 11, 13, 14, 15 } };
		solution(arr, arr1);

	}

	//
	public static void solution(ArrayList<Integer> num, int[][] nums) {

		for (int[] num2 : nums) {

			merge(num, num2);

		}

	}

	// 정렬된 상태의 배열을 정렬되도록 합치기
	public static void merge(ArrayList<Integer> nums1, int[] nums2) {

		int idx1 = nums1.size() - 1;
		int idx2 = nums2.length - 1;

		// 합칠 배열의 크기만큼 공간 확보(0으로 채우기)
		for (int i = 0; i < nums2.length; i++) {
			nums1.add(0);
		}
		int cnt = nums1.size() - 1;

		// 이미 각 배열이 정렬된 상태이기에, 맨 뒤에서부터 추가 && 인덱스 번호 --
		while (0 <= idx1 && 0 <= idx2) {

			int n1 = nums1.get(idx1);
			int n2 = nums2[idx2];

			if (n1 <= n2) {
				nums1.set(cnt, n2);
				cnt--;
				idx2--;
			} else {
				nums1.set(cnt, n1);
				cnt--;
				idx1--;
			}

		}
		while (0 <= idx2) {
			nums1.set(cnt, nums2[idx2]);
			cnt--;
			idx2--;
		}

		for (Integer element : nums1) {
			System.out.println(element);
		}

		System.out.println(" ");
	}

}
