package coding_AlgoBasic;

import java.util.Arrays;

//https://www.youtube.com/watch?v=VJWUWolxHu0&list=PLDV-cCQnUlIYFOXYzqLoXnEye4WxDa_30&index=7

//문제: [0,1,2]만으로 구성되어있는 input 을 sort하여라
public class Array2_Sort_DutchFlagProblem {

	public static void main(String[] args) {

		int[] arr = {1,1,0,2,1,1,0,2,0,0,1};
		int target = 0;
		solution(arr);

	}

	
	// 왼쪽, 오른쪽 인덱스번호, pivot 값(0번인덱스부터) 설정 후 비교 
	public static void solution(int[] nums) {

		int left=0;
		int right=nums.length-1;
		int i=1;
		
		while(i<=right) {
			
			if(nums[i] == 0) {
				int tmp = nums[i];
				nums[i] = nums[left];
				nums[left] = tmp;
				i++;
				left++;
				
			}else if(nums[i] == 2) {
				int tmp = nums[i];
				nums[i] = nums[right];
				nums[right] = tmp;
				right--;
			}
			else {
				i++;
			}
		}
		

		System.out.println(Arrays.toString(nums));
		
		
	}

}
