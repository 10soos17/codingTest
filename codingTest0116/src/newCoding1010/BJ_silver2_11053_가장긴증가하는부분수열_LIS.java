package newCoding1010;

import java.io.*;
import java.util.*;

/* 
https://www.acmicpc.net/status?user_id=soo1017&problem_id=11053&from_mine=1

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성
예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50}, 길이는 4

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)
둘째 줄에는 수열 A를 이루고 있는 Ai(1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력

ex.
입력 
6
10 20 10 30 20 50
출력 
4
*/
public class BJ_silver2_11053_가장긴증가하는부분수열_LIS {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int dp[] = new int[N];
        int max = 1;
        
        for(int i = 0; i < N; i++) {
        	dp[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if(arr[i] > arr[j]) {
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		}
        	}
        	max = Math.max(max, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(max);
	}

}
/*
 [3, 2, 4, 1]
 [1, 1, 1, 1]
*/
