package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
https://www.acmicpc.net/problem/2110
도현이의 집 N개가 수직선 위에 있다. 
각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
도현이는 언제 어디서나 와이파이를 즐기기 위해서 
집에 공유기 C개를 설치하려고 한다. 
한 집에는 공유기를 하나만 설치할 수 있고, 
가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 
둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

출력
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다
ex.
5 3
1
2
8
4
9

3
*/
public class BJ_gold4_2110_공유기설치_이진트리 {
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		/*
		int len = 987654321;
		int now = arr[0];
		int n = (N+1)/M;
		int idx = n;
		while(idx<N) {
			int next = arr[idx];
			len = Math.min(len, next-now);
			now = next;
			idx+=n;
		}
		System.out.println(len);
		*/
		
		int l = 0;
		int r = M - 1;
		int cnt = 2;
		int max = arr[r] - arr[l];
		while(cnt < M) {
			int mid = (l+r)/2;
			if(arr[mid] - arr[l] < arr[r] - arr[mid]) r = mid
			if(calc(mid) < M) r = mid;
			else {l = mid + 1;}
		}
		System.out.println(l-1);
	}
	static long calc(int mid) {
		long tmp = 0;
		for(int i=0; i < N; i++) {
			long num = arr[i] - mid;
			if(num > 0) {
				tmp = tmp + (arr[i] - mid);
			}
		}
		return tmp;
	}
}