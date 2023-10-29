package coding_BaekJoon;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.youtube.com/watch?v=izYANwrHwvQ&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=13
//https://www.acmicpc.net/problem/11404

//다익스트라: 한점에서 다른 점 최소비용
//아이디어
/*
5 (정점개수(v))
14 (총 간선개수(e))
(각 간선을 나타내는 세 개의 정수 (u, v, w)
 정점(u) 다른 정점(v) 가중치(w))

1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

 */

public class EveryShortestPath_플로이드 {

	public static void main(String[] args) {
		int v = 5;
		int e = 14;
		int[][] arr = { { 1, 2, 2 }, { 1, 3, 3 }, { 1, 4, 1 }, { 1, 5, 10 }, { 2, 4, 2 }, { 3, 4, 1 }, { 3, 5, 1 },
				{ 4, 5, 3 }, { 3, 5, 10 }, { 3, 1, 8 }, { 1, 4, 2 }, { 5, 1, 7 }, { 3, 4, 2 }, { 5, 2, 4 } };

		HashMap<Integer, ArrayList<ArrayList<Integer>>> edge = putPath(arr);
		solution(v, e, edge);

	}

	// 정점별 간선, 가중치 자료구조
	// map의 key = 정점
	// map의 value = ArrayList<ArrayList<Integer>>로 간선별 저장
	public static HashMap<Integer, ArrayList<ArrayList<Integer>>> putPath(int[][] arr) {
		HashMap<Integer, ArrayList<ArrayList<Integer>>> edge = new HashMap<>();
		ArrayList<ArrayList<Integer>> mList = new ArrayList<>();
		ArrayList<Integer> lList = new ArrayList<>();


		for (int[] element : arr) {
			int p = element[0];
			int p2 = element[1];
			int w = element[2];

			if (edge.get(p) != null) {
				mList = edge.get(p);
			} else {
				mList = new ArrayList<>();
			}
			lList = new ArrayList<>();
			lList.add(p2);
			lList.add(w);
			mList.add(lList);
			edge.put(p, mList);

		}

		for (int l : edge.keySet()) {
			System.out.println(l + ":" + edge.get(l));
		}

		return edge;

	}

	// 모든 노드 ->모 노드로의 최단 가중치 값 찾기
	// 가중치 값 리스트 : int[][] 이중배열, 길이는 정점+1(인덱스 번호를 정점으로 쓰려고, 인덱스0은 의미없음) / 가장 큰 값 넣어두기
	public static void solution(int v, int e, HashMap<Integer, ArrayList<ArrayList<Integer>>> edge) {

		int[][] dist = new int[v + 1][v + 1];// 정점별 가중치 리스트
		for (int i = 0; i < v + 1; i++) {
			for (int j = 0; j < v + 1; j++)
				if (i == j) {
					dist[i][j] = 0;// 자기 자신에서 자기 자신으로 오는 경우는 가중치 0으로 세팅
				} else {
					dist[i][j] = 999999999;
				}
		}

		for (Integer point : edge.keySet()) {

			ArrayList<ArrayList<Integer>> l = edge.get(point);
				// System.out.println("point:"+point);

				for (ArrayList<Integer> ll : l) {
					int nv = ll.get(0);
					int nw = ll.get(1);

					dist[point][nv] = Math.min(dist[point][nv], nw);

				}

		}

		//j-------------->k
		//j------>i------>k
		for(int i = 1; i < v + 1; i++) {//거치는 값
			for(int j = 1; j < v + 1; j++) { //시작
				for(int k = 1; k < v + 1; k++) {//도착
					if(dist[j][k] > dist[j][i] + dist[i][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
					}
				}
			}

		}


		for (int i = 1; i < v + 1; i++) {
			for (int j = 1; j < v + 1; j++) {
				if (dist[i][j] == 999999999) {
					System.out.print("INF"+" ");
				} else {
					System.out.print(dist[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
