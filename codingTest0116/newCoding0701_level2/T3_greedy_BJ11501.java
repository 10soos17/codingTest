package newCoding0701_level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2304
//7
//2 4
//11 4
//15 8
//4 6
//5 3
//8 10
//13 6
public class T3_greedy_BJ11501 {

	public static void main(String[] args) throws Exception{
		//byte로 들어온 데이터를 -> char 형태로 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int CNT = Integer.parseInt(br.readLine());
		int[][] map = new int[CNT][2];
		int sum=0;
		int maxIdx=0;
		int maxVal=0;

		StringTokenizer st = null;
		for(int i=0;i<CNT;i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[i][0] =  Integer.parseInt(st.nextToken());
			map[i][1] =  Integer.parseInt(st.nextToken());
			if(maxVal < map[i][1]) {
				maxVal = map[i][1];
			}
		}

		int beforeIdx=0;
		Arrays.sort(map, (o1,o2)-> o1[0]-o2[0]);

		for(int i=0;i<map.length;i++) {
			if(maxVal==map[i][1]) {
				maxIdx=i;
				break;
			}
		}

		for(int i=1;i<=maxIdx;i++) {
//			System.out.println(i);
			if(map[beforeIdx][1] <= map[i][1]) {
				sum+=(map[i][0] - map[beforeIdx][0]) * map[beforeIdx][1];
				beforeIdx=i;
				//System.out.println("sum"+sum);
			}
		}
		beforeIdx=map.length-1;

		for(int i=map.length-1;i>maxIdx;i--) {
//			System.out.println("max"+i);
			if(map[i-1][1] >= map[beforeIdx][1]) {
				sum+=(map[beforeIdx][0] - map[i-1][0]) * map[beforeIdx][1];
				//System.out.println("maxsum"+sum);
				beforeIdx=i-1;
			}
		}
		sum+=maxVal;

		System.out.println(sum);
	}


}
