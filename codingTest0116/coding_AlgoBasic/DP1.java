package coding_AlgoBasic;

import java.util.Arrays;

//https://www.youtube.com/watch?v=lhZTYwHgrDM&list=PLDV-cCQnUlIa0owhTLK-VT994Qh6XTy4v&index=3

public class DP1 {

	public static void main(String[] args) {

//		int[] arr1 = { 0,1,2 };
//		int target1 = 7;
//		solution1(arr1, target1);
//
//		int[] arr2 = {1,2,4,6,2,4,6,1};
//		solution2(arr2);
//
//		int[][] arr3 = {{1,3,1,2},{2,4,5,2},{3,4,5,6},{1,5,6,2}};
//		solution3(arr3);

		int[] arr4 = { 2,3,5 };
		int target2 = 10;
		solution4(arr4, target2);

	}
	//문제:n개의 계단을 오르고자 한다. 한번에 1개, 2개씩의 계단을 오를수 있을때 총 몇가지 방벙으로 계단을 오를 수 있는가?
	//피보나치
	public static void solution1(int[] arr, int target) {

		int [] answer = new int[target+1];

		for(int i=0;i<arr.length;i++) {
			answer[i] = arr[i];
		}
		if(target < arr.length) {
			answer[target] = arr[target];
		}

		for(int i=3;i<target+1;i++) {
			int way = answer[i-1] + answer[i-2];
			answer[i]=way;
		}


		System.out.println(Arrays.toString(answer)+":"+answer[target]);
	}
	//문제: i번째 계단을 오르는 비용이 cost[i]로 주어졌다. 계단을 한번에 한칸 혹은 두칸씩만 오를수 있을때, 전체 계단을 오르는 최소 비용은 얼마인가.
	public static void solution2(int[] arr) {
		int cnt = arr.length;
		int[] minCost = new int[arr.length+1];

		for(int i=2;i<minCost.length;i++) {
			int oneStep = arr[i-1] + minCost[i-1];
			int twoStep = arr[i-2] + minCost[i-2];
			System.out.println(oneStep+":"+twoStep);
			minCost[i] = Math.min(oneStep, twoStep);
			System.out.println(minCost[i]);
		}

		System.out.println(Arrays.toString(minCost)+":"+minCost[cnt]);
	}
	//https://www.youtube.com/watch?v=11oqpRgDF9Q&list=PLDV-cCQnUlIa0owhTLK-VT994Qh6XTy4v&index=4
	//문제: 2d array로 길을 가기 위한 비용이 주어진다. 왼쪽 위에서 오른족 아래까지 도달하기 위한 최소 비용은 얼마인가?
	public static void solution3(int[][] arr) {

		int row = arr.length;
		int col = arr[0].length;
		int [][] minCost = new int[row][col];

		//
		minCost[0][0] = arr[0][0];
		for(int i=1;i<col;i++) {
			minCost[0][i] = arr[0][i] + minCost[0][i-1];
		}
		for(int i=1;i<row;i++) {
			minCost[i][0] = arr[i][0] + minCost[i-1][0];
		}

		//
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++) {
				int prevCol = j-1;
				int prevRow = i-1;

				int upCost=0;
				int leftCost = 0;
				if(prevRow >= 0) {
					upCost = minCost[prevRow][j];
				}
				if(prevCol >= 0) {
					leftCost = minCost[i][prevCol];
				}
				int prevCost = Math.min(upCost, leftCost);
				int cost = prevCost + arr[i][j];
				minCost[i][j] = cost;

			}
		}
		int answer = minCost[row-1][col-1];

		System.out.println(answer);
	}

	//https://www.youtube.com/watch?v=N7m44HWa39o&list=PLDV-cCQnUlIa0owhTLK-VT994Qh6XTy4v&index=5
	//최소 갯수 동전바꾸기
	//문제: 주어진 동전 coins로 금액의 합 amount를 만들기 위한 최소한의 동전의 갯수는 몇개인가?
	public static void solution4(int[] arr, int target) {

		int maxCost = 999999999;
		int[] minCount = new int[target+1];

		for(int i=0;i<target+1;i++) {
			minCount[i] = -1;
		}

		minCount[0] = 0;
		int crntMin=0;

		for(int i=0;i<target+1;i++) {
			if(minCount[i] != -1) {
				continue;
			}

			crntMin = maxCost;
			for (int element : arr) {
				int lastIdx = i-element;
				//System.out.println(lastIdx);
				if(lastIdx < 0) {
					continue;
				}
				int lastCost = minCount[lastIdx];
				//System.out.println(lastCost);
				if(lastCost == -1) {
					continue;
				}
				int cost = lastCost + 1;
				crntMin = Math.min(cost,  crntMin);
			}
			if(crntMin == maxCost) {
				minCount[i] = -1;
			}else {
				minCount[i] = crntMin;
			}
		}
		System.out.println(Arrays.toString(minCount)+":"+minCount[target]);

	}


}










