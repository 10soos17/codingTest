package Tets9_SKC;

import java.util.Arrays;

class T2 {

//	테스트 1
//	입력값 〉
//	[[10, 10, 10, 10, 10], [5, 5, 13, 5, 10]], [[7, 10, 5, 10, 5], [0, 5, 0, 35, 5]]
//	기댓값 〉
//	[0, 0, 1, 0, 0]
//	실행 결과 〉
//	실행한 결괏값 []이 기댓값 [0,0,1,0,0]과 다릅니다.
//	테스트 2
//	입력값 〉
//	[[3, 8, 1, 7, 4]], [[1, 4, 8, 2, 10]]
//	기댓값 〉
//	[0, 0, 0, 0, 0]
//	실행 결과 〉
//	실행한 결괏값 []이 기댓값 [0,0,0,0,0]과 다릅니다.

	public static void main(String[] args) {

		String id = "bird100";

		int n = 7;
		int m = 24;
		int p = 4;

		int[] l = { 2, 4 };
		int[] ll = { 1, 3, 5 };

		String[] idList = { "bird99", "bird98", "bird101", "gotoxy" };
		String[] sll = {};

		int[][] k = { { 10, 10, 10, 10, 10 }, { 5, 5, 13, 5, 10 } };
		int[][] kk = { { 7, 10, 5, 10, 5 }, { 0, 5, 0, 35, 5 } };

		boolean[] b = { true, false, true };

		solution(k, kk);

		for(int i : tmp) {
			System.out.println(i);
		}

	}

	static int[] tmp;
	static boolean[][] visited;
	static int sum;
	static int dep;

	public static int[] solution(int[][] k, int[][] kk) {
		visited = new boolean[k.length][5];
		tmp = new int[5];

		int[][] goods = new int[k.length][k[0].length];

		for (int i = 0; i < k.length; i++) {
			for (int j = 0; j < k[0].length; j++) {
				goods[i][j] = k[i][j] - kk[i][j];
				if (j != 0)
					goods[i][j] += k[i][j - 1];
				if (goods[i][j] < 0)
					goods[i][j] = 0;

				System.out.println(goods[i][j]);
			}
		}

		if (k.length == 1)
			return tmp;
		perm(goods, new int[5], 0);

		return tmp;
	}

	static void perm(int[][] goods, int[] nTmp, int nSum) {
		if (dep == 5) {
			System.out.println(Arrays.toString(nTmp));
			if (sum < nSum) {
				sum = Math.max(sum, nSum);
				tmp = nTmp;
			} else if (sum == nSum) {
				String a = "";
				String b = "";

				for (int i = 0; i < 5; i++) {
					a += tmp[i];
					b += nTmp[i];
				}
				String[] s = { a, b };
				Arrays.sort(s);
				for (int i = 0; i < 5; i++) {
					String ss = s[0];
					tmp[i] = Integer.parseInt(ss.charAt(i) + "");
				}

			}
			dep = 0;
			return;

		}

		for (int i = 0; i < goods.length; i++) {
			for (int j = 0; j < goods[0].length; j++) {

				if (!visited[i][j]) {
					visited[i][j] = true;
					nTmp[dep] = goods[i][j];
					dep++;
					perm(goods, nTmp, nSum + goods[i][j]);
					visited[i][j] = false;
				}
			}
		}
	}
}