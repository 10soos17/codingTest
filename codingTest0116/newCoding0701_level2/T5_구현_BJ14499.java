package newCoding0701_level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// acmicpc.net/problem/14499


//동쪽은 1[0,1], 서쪽은 2[0,-1], 북쪽은 3[-1,0], 남쪽은 4[1,0]
//주사위
public class T5_구현_BJ14499 {

	public static void main(String[] args) throws Exception{
		//byte로 들어온 데이터를 -> char 형태로 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int CNT = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Number b = 3;
	
		for(int i=0;i<CNT;i++) {
			int D = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long[] map = new long[D];
			for(int j=0;j<D;j++) map[j] = Integer.parseInt(st.nextToken());
			sb.append(solution(map)).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static long solution(long[] map) {
		long sum=0;
		long max=0;
		
		for(int i=map.length-1;i>-1;i--) {
			if(map[i]>max) {
				max = Math.max(max, map[i]);
				continue;
			}
			sum+=max-map[i];
		}
		return sum;
	}

}
