package coding_AlgoBasic;

import java.util.Arrays;

public class Array1_BinarySearch {

	public static void main(String[] args) {

		int[] arr = {1,3,5,10,14,16,20};
		int target = 16;
		binarySearch(arr, target);
		
	}

	// target 숫자 찾기
	// 왼쪽, 오른쪽 인덱스번호, pivot 값(배열 가운데 인덱스) 설정 후 비교 
	public static void binarySearch(int[] nums, int target) {

		int left = 0;
		int right = nums.length-1;
		
		while(left<=right) {
			
			int pivot = (int)(left+right)/2;
			
			if(nums[pivot] == target) {
				break;
			}
			else if(nums[pivot] < target) {
				left = pivot +1;
				
			}
			else { //nums[pivot] >= target
				right = pivot -1;
			}
			
		}
		System.out.println(Arrays.toString(nums));
	}

}
