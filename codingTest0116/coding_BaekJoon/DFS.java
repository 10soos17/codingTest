package coding_BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=3_eVkTkBbJE&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=4
//https://www.acmicpc.net/problem/2667
//구현방법: 1.stack 2.재귀함수 
public class DFS {

	static int n;
	static int each;
	public static void main(String[] args) {

		int[][] list = { { 0, 1, 1, 0, 1, 0, 0 }, { 0, 1, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 0, 0 } };

		n = list.length;

		solution(list);

	}

	public static void dfs(int y, int x, int[][] list, boolean[][] check) {
		
		each+=1;
		int nx;
		int ny;
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 }; // 오른쪽,아래쪽,왼쪽, 위쪽

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (0 <= ny && ny < n && 0 <= nx && nx < n) {
				if (list[ny][nx] == 1 && check[ny][nx] == false) {

					check[ny][nx] = true;
					dfs(ny, nx, list, check);
				}

			}
		}
	}

	public static void solution(int[][] list) {

		boolean[][] check = new boolean[n][n];
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (list[i][j] == 1 && check[i][j] == false) {
					// 방문 체크 표시
					// DFS 그림 크기를 구하기
					// 결과값 저장
					check[i][j] = true;
					each = 0;
					dfs(i, j, list,check);
					//System.out.println("each:"+each);
					result.add(each);

				}
				System.out.print(list[i][j]);
			}
			System.out.println();
		}
		
		
		Collections.sort(result);
		
		System.out.print(result.size());//결과 그림의 개수 
		for (int i : result) {
			System.out.print(i);//각 그림에 포함되는 1의 수 
		}

	}

}
