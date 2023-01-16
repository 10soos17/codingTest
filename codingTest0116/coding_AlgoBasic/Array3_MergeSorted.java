package coding_AlgoBasic;

import java.util.Arrays;

//https://www.youtube.com/watch?v=V2Pd8DAHXQw&list=PLDV-cCQnUlIYFOXYzqLoXnEye4WxDa_30&index=7
//시간복잡도: o(m+n)
//공간복잡도: 0(1)
public class Array3_MergeSorted {

	public static void main(String[] args) {

		int[] arr1 = {1,3,5,0,0,0};
		int[] arr2 = {1,2,8};
		int m =3;
		int n=3;
		solution(arr1, arr2, m,n);

	}

	//정렬된 상태의 두 배열을 정렬되도록 합치기
	public static void solution(int[] nums1,int[] nums2,int m,int n) {
		
		int num1Idx = m-1;
		int num2Idx = n-1;
		int wIdx = nums1.length-1;
		
		
		if(num2Idx < 0) {
			return;
		}
		
		while(0<=num1Idx && 0 <= num2Idx) {
			
			int num1 = nums1[num1Idx];
			int num2 = nums2[num2Idx];
			
			if(num2 <= num1) {
				
				nums1[wIdx] = num1;
				num1Idx--;
				wIdx--;
				
			}else {
				
				nums1[wIdx] = num2;
				num2Idx--;
				wIdx--;
			}
		}
		
		while(0<=num2Idx) {
			nums1[wIdx] = nums2[num2Idx];
			num2Idx--;
			wIdx--;
		}
		
		System.out.println(Arrays.toString(nums1));
		
		
	}

}
