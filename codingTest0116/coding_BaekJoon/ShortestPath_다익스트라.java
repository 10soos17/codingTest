package coding_BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=izYANwrHwvQ&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=12
//https://www.acmicpc.net/problem/1753

//다익스트라: 한점에서 다른 점 최소비용 
//아이디어
/*
5 6 (정점개수(v) 간선개수(e))
1 (시작 정점번호(k))
(각 간선을 나타내는 세 개의 정수 (u, v, w)
 정점(u) 다른 정점(v) 가중치(w))
5 1 1 
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

 */

public class ShortestPath_다익스트라 {

	public static void main(String[] args) {
		int v = 5;
		int e = 6;
		int k = 1;
		int[][] arr = { { 0, 0, 0 }, { 5, 1, 1 }, { 1, 2, 2 }, { 1, 3, 3 }, { 2, 3,4 }, { 2, 4, 5 }, { 3, 4, 6 } };
		
		HashMap<Integer, ArrayList<ArrayList<Integer>>> edge = putPath(arr);
		solution(v, e, k, edge);
		
	}
	
	//정점별 간선, 가중치 자료구조 
	//map의 key = 정점
	//map의 value = ArrayList<ArrayList<Integer>>로 간선별 저장 
	public static HashMap<Integer, ArrayList<ArrayList<Integer>>> putPath(int [][] arr){
		HashMap<Integer, ArrayList<ArrayList<Integer>>> edge = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> mList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lList = new ArrayList<Integer>();
		
		lList.add(0);
		lList.add(0);
		mList.add(lList);
		edge.put(0, mList);

		
		for(int i=0;i<arr.length;i++) {
			int p = arr[i][0];
			int p2 = arr[i][1];
			int w = arr[i][2];
			
			if (edge.get(p) != null) {
				mList = edge.get(p);
			} else {
				mList = new ArrayList<ArrayList<Integer>>();
			}
			lList = new ArrayList<Integer>();
			lList.add(p2);
			lList.add(w);
			mList.add(lList);
			edge.put(p, mList);
			
		}


		for (int l : edge.keySet()) {
			System.out.println(l+":"+edge.get(l));
		}
		
		return edge;
		
	}
	
	
	//최단 가중치 값 찾기 
	//가중치 값 리스트 : 길이는 정점+1(인덱스 번호를 정점으로 쓰려고, 인덱스0은 의미없음) / 가장 큰 값을 넣어두기 
	//heap 리스트 : Queue로 만들고, 비어있을 때까지, poll로 데이터 빼기 / {가중치, 정점} 저장 
	// 			   dist가중치 값보다 작으면 값 교체 후, edge map에서 정점번호(key) 간선(value) 찾아서, 해당 간선만큼 for문 heap에 넣기 
	public static void solution(int v, int e, int k, HashMap<Integer, ArrayList<ArrayList<Integer>>> edge) {

		int[] dist = new int[v + 1];// 정점별 가중치 리스트
		for (int i=0;i<v+1;i++) {
			dist[i] = 999999999;
		}

		dist[k] = 0;// 시작 정점 가중치 초기화

		Queue<ArrayList<Integer>> heap = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> hList = new ArrayList<Integer>();
		hList.add(0);// 가중치
		hList.add(k);// 정점번호
		heap.add(hList);

		while (heap.size() > 0) {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			System.out.println("heap:"+heap.peek());
			list = heap.poll();

			int ew = list.get(0);
			int ev = list.get(1);
			
			if (dist[ev] != ew) {
				continue;
			}
			
			if(edge.get(ev) != null) {
				ArrayList<ArrayList<Integer>> l = edge.get(ev);
				//System.out.println("ev:"+ev);
				
				for(int i=0;i<l.size();i++) {
					ArrayList<Integer> ll = l.get(i);
					int nv = ll.get(0);
					int nw = ll.get(1);
					if(dist[nv] > ew + nw) {
						dist[nv] = ew + nw;
						//System.out.println("dist[nv]:"+ew + nw);
						hList = new ArrayList<Integer>();
						hList.add(dist[nv]);
						hList.add(nv);
						heap.add(hList);
						//System.out.println("heap:"+heap.peek());
					}
				}
			}else {
				continue;
			}

		}
		
		for(int i=1;i<v+1;i++) {
			if(dist[i] == 999999999) {
				System.out.print("INF");
			}else {
				System.out.print(dist[i]);
			}
			System.out.println();
		}

	}
}
