package newCoding1010;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 https://school.programmers.co.kr/learn/courses/30/lessons/1844
 제한사항
maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
maps	answer
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
*/

public class Programmers_게임맵최단거리_최단거리bfs_dfs {

	    int[][] arr;
	    int[][] dir = {{-1, 0},{0, 1},{1, 0},{0, -1}};
	    boolean[][] visited;
	    int N;
	    int M;
	    int answer = Integer.MAX_VALUE;
	    public int solution(int[][] maps) {
	        arr = maps;
	        N = maps.length;
	        M = maps[0].length;
	        visited = new boolean[N][M];
	        //dfs(0, 0, 1);
	        bfs();
	        return  answer == Integer.MAX_VALUE ? -1 : answer;
	    }
	    
	    void bfs(){
	        Queue<int[]> q = new ArrayDeque<>();
	        q.offer(new int[]{0, 0, 1});
	        visited[0][0] = true;
	        
	        while(!q.isEmpty()){
	        	int[] c = q.poll();
	            int i = c[0];
	            int j = c[1];
	            int dep = c[2];
	            
	            if(i == N - 1 && j == M - 1){
	                answer = dep;
	                return;
	            }
	            for(int d = 0; d < 4; d++){
	                int ni = i + dir[d][0];
	                int nj = j + dir[d][1];
	                if(ni < 0 || nj < 0 || ni > N - 1 || nj > M -1) continue;
	                if(!visited[ni][nj] && arr[ni][nj] == 1){
	                    visited[ni][nj] = true;
	                    q.offer(new int[]{ni, nj, dep + 1});
	                }
	            }
	            
	        }
	        
	    }
	    /*
	    void dfs(int i, int j, int dep){
	        
	        if(i == N - 1 && j == M - 1){
	            answer = Math.min(answer, dep);
	            return;
	        }
	        
	        for(int d = 0; d < 4; d++){
	            int ni = i + dir[d][0];
	            int nj = j + dir[d][1];
	            if(ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1) continue;
	            if(!visited[ni][nj] && arr[ni][nj] == 1){
	                visited[ni][nj] = true;
	                dfs(ni, nj, dep + 1);
	                visited[ni][nj] = false;
	            }
	        }
	    }*/
	    
	}