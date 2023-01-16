package coding_AlgoBasic;

import java.util.Arrays;

//https:https://www.youtube.com/watch?v=zChSh4yOOCg&list=PLDV-cCQnUlIYFOXYzqLoXnEye4WxDa_30&index=8
//시간복잡도: 
//공간복잡도: 
public class Array4_FindPeakElement {

	public static void main(String[] args) {

		int[] arr1 = {1,3,2,4,5,7,6};
		solution(arr1);

	}

	//양쪽의 수보다 본인이 더 큰 수 찾기 
	public static void solution(int[] nums) {

		int left = 0;
		int right = nums.length-1;
		
		while(left < right) {
			int pivot = (int)(left+right)/2;
			int num = nums[pivot];
			int nextNum = nums[pivot+1];
			
			if(num < nextNum) {
				left = pivot +1;
				//System.out.println(pivot);
					
			}else {
				right = pivot;
				//System.out.println("right"+pivot);
			}
			
		}
		System.out.println(right);//left=right
		
		
	}

}
