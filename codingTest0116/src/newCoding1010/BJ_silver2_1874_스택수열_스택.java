package newCoding1010;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.synth.SynthOptionPaneUI;

// https://www.acmicpc.net/problem/1874
/*
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 
제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 
둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. 
push연산은 +로, pop 연산은 -로 표현하도록 한다. 
불가능한 경우 NO를 출력한다

8
4
3
6
8
7
5
2
1

+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
========
5
1
2
5
3
4

NO
 */
public class BJ_silver2_1874_스택수열_스택 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		Stack<Integer> stack = new Stack<>(); 
		boolean flag = false;
		int before = 987654321;
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(br.readLine());
			/*if(flag) {
				if(before < now) {
					System.out.println("NO");
					return;
				}
				
			}
			if(now == N) {
				flag = true;
			}
			before = now;*/
			q.offer(now);
		}
		int idx=1;
		while(true) {
			int n = q.poll();
			if(idx <= n) {
				while(idx <= n) {
					stack.push(idx);
					sb.append("+\n");
					idx++;
				}
			}else {
				int s = stack.pop();
				while(s >= n) {
					if(s != n) {
						System.out.println("NO");
						return;
					}
					sb.append("-\n");
					s = stack.pop();
				}
				
			}
			if(n == N) break;
		}
		while(!stack.isEmpty()) {
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb.toString());
	}
}
