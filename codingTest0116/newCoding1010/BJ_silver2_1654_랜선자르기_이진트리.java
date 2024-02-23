package newCoding1010;
//11600
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
https://www.acmicpc.net/problem/1654
편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 
기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자. 
그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. 
N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.
이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.
입력
첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 
그리고 필요한 랜선의 개수 N이 입력된다. 
K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 
그리고 항상 K ≦ N 이다. 
그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다. 
랜선의 길이는 231-1보다 작거나 같은 자연수이다.

출력
첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다
ex.
4 12
802
743
457
539

200
*/
public class BJ_silver2_1654_랜선자르기_이진트리 {
	static int N;
	static int M;
	static long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		long l = 0;
		long r = 0;
		for(int i = 0; i<N;i++) {
			long num = Integer.parseInt(br.readLine());
			arr[i] = num;
			r = Math.max(r, num);
		}
		r++;
		while(l<r) {
			long mid = (l+r)/2;
			if(calc(mid)< M) r = mid;
			else {l = mid + 1;}
		}
		System.out.println(l-1);
	}
	static long calc(long mid) {
		long tmp = 0;
		for(int i=0; i < N; i++) {
			tmp = tmp + (arr[i]/mid);
		}
		return tmp;
	}
}
