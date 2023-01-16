package newCoding0628_level1;

class T3_plusMatrix {
//	행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과
//	2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환
//	arr1	arr2	return
//			[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
//			[[1],[2]]	[[3],[4]]	[[4],[6]]
	public static void main(String[] args) {
		int[][] n = { { 1, 2 }, { 2, 3 } };
		int[][] m = { { 3, 4 }, { 5, 6 } };
		int[][] res = solution(n, m);

		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length; j++) {
				System.out.println(res[i][j]);
			}
		}

	}

	public static int[][] solution(int[][] n, int[][] m) {
		int[][] answer = new int[n.length][n.length];

		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length; j++) {
				answer[i][j] = n[i][j] + m[i][j];
			}
		}

		return answer;
	}
}