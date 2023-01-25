package Test3_programmers_DM0703;

public class T2 {

	public static void main(String[] args) {
		int n = 4;
		boolean m = true;

		int[][] res = solution(n, m);
		for (int[] re : res) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.println(re[j]);
			}
		}

	}

	public static int[][] solution(int n, boolean m) {
		int[][] answer = new int[n][n];
		int sign = 2;
		int gap = 0;
		int limit = n * n;
		int idxR = 0;
		int idxC = 0;
		answer[0][0] = 1;

		if (m) {

			while (limit > 0) {
				int num = gap % 2;
				switch (num) {
				case 0:

					System.out.println(1);
					for (int i = idxC; i <= gap; i++) {
						idxC++;
						answer[idxR][idxC] = sign;
						sign++;
						limit--;
						mapPrint(answer);
					}
					idxR++;

					System.out.println(2);
					for (int i = idxR; i >= 0; i--) {

						answer[idxR][idxC] = sign;
						sign++;
						limit--;
						idxC--;

						mapPrint(answer);
					}
					idxR++;

				case 1:

					System.out.println(3);
					for (int i = idxR; i <= gap; i++) {
						idxR++;
						answer[i][idxC] = sign;
						sign++;
						limit--;
						mapPrint(answer);
					}

					System.out.println(4);
					for (int i = idxC; i >= 0; i--) {
						answer[idxR][i] = sign;
						sign++;
						limit--;
						mapPrint(answer);
					}

				}
				gap++;
			}
		} else {
			answer[0][0] = 1;
			answer[1][0] = 2;
			answer[1][1] = 3;
			answer[0][1] = 4;

			while (limit > 0) {
				int num = gap % 2;
				switch (num) {

				case 0:
					idxR--;
					idxC++;
					for (int i = idxR; i <= gap; i++) {
						idxR++;
						answer[i][idxC] = sign;
						sign++;
						limit--;
						System.out.println(1);
						mapPrint(answer);
					}
					idxR--;
					idxC--;
					for (int i = idxC; i >= 0; i--) {
						answer[idxR][i] = sign;
						sign++;
						limit--;
						System.out.println(2);
						mapPrint(answer);
					}
					idxC--;

				case 1:
					idxR--;
					idxC++;
					for (int i = idxC; i <= gap; i++) {
						idxC++;
						answer[idxR][i] = sign;
						sign++;
						limit--;
						System.out.println(3);
						mapPrint(answer);
					}
					//idxC--;
					idxR--;

					for (int i = idxR; i >= 0; i--) {
						idxR--;
						answer[i][idxC] = sign;
						sign++;
						limit--;
						System.out.println(4);
						mapPrint(answer);
					}
					idxC++;



				}
				gap++;
			}
		}

		return answer;
	}

	public static void mapPrint(int[][] res) {

		for (int[] re : res) {
			for (int j = 0; j < res[0].length; j++) {

				System.out.print(re[j] + " ");
			}
			System.out.println();
		}

	}
}