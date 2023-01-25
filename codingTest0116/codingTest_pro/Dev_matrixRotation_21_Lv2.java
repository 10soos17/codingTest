package codingTest_pro;

import java.util.ArrayList;
import java.util.Collections;

public class Dev_matrixRotation_21_Lv2 {

	public static void main(String[] args) {
		//6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	-> [8, 10, 25]
		int r=6;
		int c=6;
		int[][] q= {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

		solution(r,c,q);

	}

	public static int[] solution(int rows, int columns, int[][] queries) {

		int[] answer = new int[queries.length];

		int[][] list = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				list[i][j] = (i * columns) + (j + 1);
			}
		}

		int UD = 0;
		int RL = 0;

		for (int i = 0; i < queries.length; i++) {
			UD = queries[i][2] - queries[i][0];
			RL = queries[i][3] - queries[i][1];

			ArrayList<Integer> minList = new ArrayList<>();

			int x = queries[i][0] - 1;
			int y = queries[i][1] - 1;

			int tmp = list[x][y];
			int b = 0;

			while (RL > 0) {
				minList.add(list[x][y]);

				y++;
				b = list[x][y];
				list[x][y] = tmp;
				tmp = b;

				RL--;
			}

			while (UD > 0) {
				minList.add(list[x][y]);

				x++;
				b = list[x][y];
				list[x][y] = tmp;
				tmp = b;
				UD--;

			}

			while (RL < queries[i][3] - queries[i][1]) {
				minList.add(list[x][y]);

				y--;
				b = list[x][y];
				list[x][y] = tmp;
				tmp = b;

				RL++;
			}
			while (UD < queries[i][2] - queries[i][0]) {
				minList.add(list[x][y]);

				x--;
				b = list[x][y];
				list[x][y] = tmp;
				tmp = b;

				UD++;
			}

			Collections.sort(minList);
			answer[i] = minList.get(0);

		}
		return answer;

	}
}
