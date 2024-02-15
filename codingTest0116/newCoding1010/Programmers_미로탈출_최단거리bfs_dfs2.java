package newCoding1010;

import java.util.ArrayDeque;
import java.util.Queue;
/*
 https://school.programmers.co.kr/learn/courses/30/lessons/159993

문제 설명
1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 
벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 
통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 
레버 또한 통로들 중 한 칸에 있습니다. 
따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 
이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 
미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 
만약, 탈출할 수 없다면 -1을 return 해주세요.

제한사항
5 ≤ maps의 길이 ≤ 100
5 ≤ maps[i]의 길이 ≤ 100
maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
S : 시작 지점
E : 출구
L : 레버
O : 통로
X : 벽
시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.

maps	result
["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	16
["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	-1
*/

public class Programmers_미로탈출_최단거리bfs_dfs2 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
	static char arr[][];
	static boolean visited[][];
	static int N;
	static int M;
	static int[] S = new int[2];
	static int[] E = new int[2];
	static int[] L = new int[2];
	static int[] answer = new int[2];
	static boolean check = false;

	//public int solution(String[] map) {
	public static void main(String[] args) throws Exception {
    	String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
       
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        arr = new char[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = maps[i].charAt(j);
                if(arr[i][j] == 'S'){
                    S[0] = i; S[1] = j;
                }
                if(arr[i][j] == 'L'){
                    L[0] = i; L[1] = j;
                }
                if(arr[i][j] == 'E'){
                    E[0] = i; E[1] = j;
                }
            }
        }
        bfs();
        if(check){
        	visited = new boolean[N][M];
        	System.out.println("레버");
            bfs();
            System.out.println(answer[0] + answer[1]);
        }
        // return  answer[0] == 0? -1: answer[1] == 0? -1 : answer[0] + answer[1];
    }

	static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        
        if(check){
        	q.offer(new int[] {L[0], L[1], 0});
    	    visited[L[0]][L[1]] = true;
    	    System.out.println("222222");
        }
        else {
	        q.offer(new int[]{S[0], S[1], 0});
	        visited[S[0]][S[1]] = true;
	        System.out.println("11111");
        }
        
        while(!q.isEmpty()){
            int[] c = q.poll();
            int ci = c[0];
            int cj = c[1];
            int dep = c[2];
            
            if(check && ci == E[0] && cj == E[1]){
                answer[1] = dep;
                System.out.println("test2:"+answer[1]);
                return;
            }
            else if(!check && ci == L[0] && cj == L[1]){
            	answer[0] = dep;
                check = true;
                System.out.println("test1:"+answer[0]);
                return;
            }
            for(int i = 0; i < 4; i++){
                int di = ci + dir[i][0];
                int dj = cj + dir[i][1];
                if(di < 0 || dj < 0 || di > N - 1 || dj > M - 1) continue;
                if(!visited[di][dj] && arr[di][dj] != 'X'){
                    visited[di][dj] = true;
                    q.offer(new int[]{di, dj, dep + 1});
                    System.out.println(check + ":"+dep);
                }
            
            }
        }
	}
}
