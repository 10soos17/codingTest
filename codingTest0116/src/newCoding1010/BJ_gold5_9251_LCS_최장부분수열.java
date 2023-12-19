package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/* 
https://www.acmicpc.net/problem/9251
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 
문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

ex.
ACAYKP
CAPCAK

4
*/
public class BJ_gold5_9251_LCS_최장부분수열 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String f = br.readLine();
		int sSize = s.length();
		int fSize = f.length();
		int[][] dp = new int[sSize + 1][fSize + 1];
		Stack<Character> stack = new Stack<>();
		for(int i = 1; i < sSize + 1; i++) {
			char now = s.charAt(i - 1);
			for(int j = 1; j < fSize + 1; j++) {
				if(now == f.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[sSize][fSize]);
		
		// +++++ 추가구현: 최장 문자열 찍어보기 
		while(sSize > 0 && fSize > 0) {
			if(fSize<0 || sSize<0) break;
			int now = dp[sSize][fSize];
			if(dp[sSize - 1][fSize] < now && dp[sSize][fSize - 1] < now) {
				stack.add(s.charAt(sSize - 1));
				sSize--; fSize--;
			}
			else if(dp[sSize - 1][fSize] == now) {
				sSize--;
			}else {
				fSize--;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}

}
