package newCoding0523;

//행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행,
//같은 열의 값을 서로 더한 결과가 됩니다.
//2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환
//[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
public class T13_plusRowCol {
	public static void main(String[] args) {

		int[][] arr1 = { { 1, 2 }, { 1, 2 }, { 2, 3 } };
		int[][] arr2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		int[][] answer = solution(arr1, arr2);

		for (int i = 0; i < arr1.length - 1; i++) {
			for (int j = 0; j < arr1[0].length - 1; j++) {
				System.out.println(answer[i][j]);

			}
		}

	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {

		int[][] answer = new int[arr1.length][arr1[0].length];

		System.out.println(arr1[0].length);
		System.out.println(arr1.length);

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				System.out.println("====:" + arr1[i][j]);
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}

	public static int[][] solution2(int[][] arr1, int[][] arr2) {

		int[][] answer = {};
		answer = arr1;

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				answer[i][j] += arr2[i][j];
			}
		}

		return answer;
	}

}