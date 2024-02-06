package newCoding1010;

import java.util.StringTokenizer;

/* 

*/
public class Programmers_파괴되지않은건물_2차원배열구간합 {

	public static void main(String[] args) throws Exception {
		int[][] board = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] skill = { { 1, 1, 1, 2, 2, 4 }, { 1, 0, 0, 1, 1, 2 }, { 2, 2, 0, 2, 0, 100 } };

		// System.out.println(solution(board, skill));
		System.out.println(solution2(board, skill));

	}
	static int N;
	static int M;
	static int[][] map;
	static int solution2(int[][] board, int[][] skill) {
		int answer = 0;
		N = board.length;
		M = board[0].length;
		map = new int[N+1][M+1];

		for (int i = 0; i < skill.length; i++) {
			int sy = skill[i][1];
			int sx = skill[i][2];
			int ey = skill[i][3];
			int ex = skill[i][4];
			int amount = skill[i][5];
			//누적합 구간 만들기
			if (skill[i][0] == 1) { // -: 좌상, 우하-//우상, 좌하+(끝영향없게만들기)
				map[sy][sx] -= amount;//좌상
				map[sy][ex+1] += amount;//우상
				map[ey+1][sx] += amount;//좌하
				map[ey+1][ex+1] -= amount;//우하
			} else { // +: 좌상, 우하+//우상, 좌하-(끝영향없게만들기)
				map[sy][sx] += amount;
				map[sy][ex+1] -= amount;
				map[ey+1][sx] -= amount;
				map[ey+1][ex+1] += amount;
			}
		}
		operate();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] + board[i][j] > 0) answer++;
			}
		}
		
		return answer;
	}
	//원래 데미지 구간 계산
	static void operate() {
        // 상하
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
            	map[y][x] += map[y - 1][x];
            }
        }
        // 좌우
        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
            	map[y][x] += map[y][x-1];
            }
        }
    }
	
	static int solution(int[][] board, int[][] skill) {
		int N = board.length;
		int M = board[0].length;
		int answer = N * M;
		for (int i = 0; i < skill.length; i++) {
			int sy = skill[i][1];
			int sx = skill[i][2];
			int ey = skill[i][3];
			int ex = skill[i][4];
			int amount = skill[i][5];
			if (skill[i][0] == 1) { // -
				for (int j = sy; j < ey + 1; j++) {
					for (int k = sx; k < ex + 1; k++) {
						int before = board[j][k];
						board[j][k] -= amount;
						if (before > 0 && board[j][k] <= 0)
							answer--;
					}
				}
			} else { // +
				for (int j = sy; j < ey + 1; j++) {
					for (int k = sx; k < ex + 1; k++) {
						int before = board[j][k];
						board[j][k] += amount;
						if (before <= 0 && board[j][k] > 0)
							answer++;
					}
				}
			}
		}
		return answer;
	}
}