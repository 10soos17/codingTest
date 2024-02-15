package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/68936

0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr
이 arr을 쿼드 트리와 같은 방식으로 압축

당신이 압축하고자 하는 특정 영역을 S라고 정의
만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축
그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도
arr이 매개변수로 주어짐
위와 같은 방식으로 arr을 압축했을 때, 
배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return

arr	result
[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	[4,9]
[[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]	[10,15]
*/
public class Programmers_쿼드압축후개수세기_부분집합 {
	    
		static int[][] map;
		static int[] answer = new int[2];
	    public int[] solution(int[][] arr) {
	    	map = new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
	    	dfs(0, 0, map[0][0], map.length);
	    	
	    	return answer;

	    }
	    static void dfs(int y, int x, int v, int size) {
	    	boolean flag = true;
	    	OUTLOOP:
	    	for(int i = y; i < y + size; i++) {
	    		for(int j = x; j < x + size; j++) {
	    			if(map[i][j] != v) {
	    				flag = false;
	    				break OUTLOOP;
	    			}
	    		}
	    	}
	    	if(flag) {
	    		answer[v]++;
	    		return;
	    	}
	    	
	    	dfs(y, x, map[y][x], size / 2);
	    	dfs(y, x + size / 2, map[y][x + size / 2], size / 2);
	    	dfs(y + size / 2, x, map[y + size / 2][x], size / 2);
	    	dfs(y + size / 2, x + size / 2, map[y + size / 2][x + size / 2], size / 2);
	    	
	    }
	}