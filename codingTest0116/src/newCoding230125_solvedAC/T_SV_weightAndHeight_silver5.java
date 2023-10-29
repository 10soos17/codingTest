package newCoding230125_solvedAC;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7568

public class T_SV_weightAndHeight_silver5 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [][] map = new int[N][3];
		
		for(int i=0; i < N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i < N; i++) {
			for(int j=i+1; j < N; j++) {
				if(map[i][0] > map[j][0] && map[i][1] > map[j][1] ) map[j][2]++;
				else if(map[i][0] < map[j][0] && map[i][1] < map[j][1]) map[i][2]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(map[i][2]+1).append("\n");
		}
		System.out.println(sb.toString());
		
		
	}
}
