package coding_AlgoBasic;

import java.util.Arrays;

public class Sorting1_Algotithm {

	public static void main(String[] args) {

		int[] arr = { 10, 1, 13, 3, 9, 5, 7 };

		bubbleSorting(arr);

		int[] arr1 = { 10, 1, 13, 3, 9, 5, 7 };
		InsertionSorting(arr1);

		int[] arr2 = { 10, 1, 13, 3, 9, 5, 7 };
		SelectionSorting(arr2);

		int[] arr3 = { 10, 1, 13, 3, 9, 5, 7 };
		MergeSorting(arr3);

		int[] arr4 = { 10, 1, 13, 3, 9, 5, 7 };
		int start = 0;
		int end = arr.length-1;
		QuickSorting(arr4 ,start,end);

		int[] arr5 = { 10, 1, 13, 3, 9, 5, 7 };
		CountingSorting(arr5);

		int nums[] = { 100, 1000, 22, 144, 3, 923, 94, 999, 99999 };
		RadixSorting(nums);
	}

	// ==========================================================================================================
	// 버블벙렬 : o(n^2), stable
	public static void bubbleSorting(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int tmp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));

	}

	// ==========================================================================================================
	// 삽입정렬 : o(n^2), stable
	public static void InsertionSorting(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			int tmp = nums[i];
			int idx = i - 1;

			// i보다 좌측에서 i인덱스 값보다 큰 값 있는한, 값 바꿔주기
			while (0 <= idx && tmp < nums[idx]) {
				nums[idx + 1] = nums[idx];
				idx -= 1;
			}
			nums[idx + 1] = tmp;
		}
		System.out.println(Arrays.toString(nums));
	}

	// ==========================================================================================================
	// 선택정렬 : o(n^2)
	public static void SelectionSorting(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			int minNum = nums[i];
			int minIdx = i;

			// i보다 우측에서 더 작은 값 찾아서 변수에 값, 인덱스 저장
			for (int j = i; j < nums.length; j++) {
				if (nums[j] < minNum) {
					minNum = nums[j];
					minIdx = j;
				}
			}
			// 해당 인덱스를 찾은 값으로 swap
			int tmp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = tmp;
		}
		System.out.println(Arrays.toString(nums));
	}

	// ==========================================================================================================
	// 병합정렬 : o(nlogn), stable
	public static int[] MergeSorting(int[] nums) {

		int[] sortedNums = new int[nums.length];

		int len = nums.length;
		if (len == 1) {
			return sortedNums;
		}
		// 배열 반 나눠서 두 배열로 저장
		int mid = len / 2;

		int[] leftNums = new int[mid];
		for (int i = 0; i < leftNums.length; i++) {
			leftNums[i] = nums[i];
		}
		int[] rightNums = new int[len - mid];
		for (int i = 0; i < rightNums.length; i++) {
			rightNums[i] = nums[i + mid];
		}

//			leftNums = MergeSorting(leftNums);
//			rightNums = MergeSorting(rightNums);
//			System.out.println(leftNums.length+":"+leftNums[0]+","+leftNums[leftNums.length-1]);
//			System.out.println(rightNums.length+":"+rightNums[0]+","+rightNums[rightNums.length-1]);

		// 병합====================
		// ArrayList<Integer> sortedNums = new ArrayList<>();
		int l = 0;
		int r = 0;
		int i = 0;
		while (l < leftNums.length || r < rightNums.length) {

			if (l == leftNums.length) {
				// System.out.println("l == leftNums.length");
				sortedNums[i] = rightNums[r];
				r++;
				i++;
				continue;
			}
			if (r == rightNums.length) {
				// System.out.println("r == rightNums.length");
				sortedNums[i] = leftNums[l];
				l++;
				i++;
				continue;
			}
			if (leftNums[l] > rightNums[r]) {
				// System.out.println("leftNums[l]>rightNums[r]");
				sortedNums[i] = rightNums[r];
				r++;
				i++;
			} else if (leftNums[l] <= rightNums[r]) {
				// System.out.println("leftNums[l]<=rightNums[r]");
				sortedNums[i] = leftNums[l];
				l++;
				i++;
			}
		}

		for (Integer idx : sortedNums) {
			System.out.print(idx + " ");
		}
		System.out.println();
		return sortedNums;

	}

	// ==========================================================================================================
	// 퀵선택 : o(n) ~ o(n^2) partitioning(pivot설정하고 왼쪽에 작은수, 오른쪽에 큰수)
	// 퀵정렬 : o(nlogn) ~ o(n^2) partitioning
	static int n=0;
	public static void QuickSorting(int[] nums, int start, int end) {
		n+=1;
		System.out.println(n+"th");
		//10, 1, 13, 3, 9, 5, 7
		if(start>end) {
			return;
		}
		int mid = start+(end-start)/2;
		int pivot = nums[mid];
		int i=start;
		int j=end;

		System.out.println("mid:"+ mid+", pivot:"+pivot);

		while(i<=j) {
			while(nums[i]<pivot) {
				System.out.println("1: "+i);
				i++;
			}
			while(nums[j]>pivot) {
				System.out.println("2: "+j);
				j--;
			}
			if(i<=j) {
				System.out.println("swap:"+i+":"+j);
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
			System.out.println("after: "+Arrays.toString(nums));

		}
		if(start<j) {
			System.out.println("\n1 recur:j:"+j);
			QuickSorting(nums,start,j);
			System.out.println("\n1 after QuickSorting: ");
			for(int num :nums) {
				System.out.print(num + " ");
			}
		}
		if(end>i){
			System.out.println("\n2 recur:i:"+i);
			QuickSorting(nums,i,end);
			System.out.println("\n2 after QuickSorting: ");
			for(int num :nums) {
				System.out.print(num + " ");
			}
		}

//		System.out.println("\nQuickSorting: ");
//		for(int num :nums) {
//			System.out.print(num + " ");
//		}

	}

	// ==========================================================================================================
	// 힙정렬 : o(n*logn)
	public static void HeapSorting(int[] nums) {

	}

	// ==========================================================================================================
	// 카운팅정렬 : 시간복잡도 o(n+k), 공간복잡도 o(k), stable
	// 배열
	// 1 해당숫자빈도(count 배열)
	// 2 누적 count 배열
	// 3 위치 저장(누적 count-1 시킬 배열)
	// 4 정렬시킬 배열
	public static void CountingSorting(int[] nums) {

		int maxNum = 0;
		for (int num : nums) {
			if (num > maxNum) {
				maxNum = num;
			}
		}
		maxNum += 1;

		int count[] = new int[maxNum];
		int acc_count[] = new int[maxNum];
		int set_idx[] = new int[maxNum];
		int sortedNums[] = new int[nums.length];
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}
		// System.out.println(Arrays.toString(count));
		for (int i = 0; i < maxNum; i++) {
			sum += count[i];
			acc_count[i] = sum;
			set_idx[i] = sum - 1;
		}
		// System.out.println(Arrays.toString(acc_count));
		// System.out.println(Arrays.toString(set_idx));
		for (int i = 0; i < nums.length; i++) {
			sortedNums[set_idx[nums[i]]] = nums[i];
			set_idx[nums[i]] -= 1;
		}

		System.out.println("\n" + "countingSorting:" + Arrays.toString(sortedNums));
	}

	// ==========================================================================================================
	// Radix정렬 : o(w*(n+k)) w는 제일 큰 수의 자리수 개수, k는 10(0~9)
	public static void RadixSorting(int[] nums) {

		int maxNum = 0;
		for (int num : nums) {
			int sum = 0;
			int tmp = num;
			while (tmp > 0) {
				tmp /= 10;
				sum += 1;
			}
			if (maxNum < sum) {
				maxNum = sum;
			}
		}
		// System.out.println(maxNum);

		int cnt = 0;
		while (maxNum > cnt) {

			nums = RadixSorting_sorted(nums, cnt);
			cnt += 1;

			System.out.println("RadixSorting:" + Arrays.toString(nums));
		}

	}

	public static int[] RadixSorting_sorted(int[] nums, int maxNum) {

		int count[] = new int[10];
		int multi = (int) Math.pow(10, maxNum);

		for (int num : nums) {
			int idx = (num / multi) % 10;
			// System.out.println(idx);
			count[idx]++;
		}

		int acc_count[] = new int[10];
		int set_idx[] = new int[10];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += count[i];
			acc_count[i] = sum;
			set_idx[i] = acc_count[i] - 1;
		}
		int sorted[] = new int[nums.length];

		// 배열 값 뒤부터
		for (int i = nums.length - 1; i >= 0; i--) {
			int idx = nums[i] / multi % 10;
			int tmp = set_idx[idx];
			sorted[tmp] = nums[i];
			set_idx[idx] -= 1;
		}
		return sorted;

	}
	// ==========================================================================================================
}
