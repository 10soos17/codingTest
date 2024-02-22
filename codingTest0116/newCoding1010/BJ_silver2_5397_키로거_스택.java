package newCoding1010;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// https://www.acmicpc.net/problem/5397
/*
 * 입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한줄로 이루어져 있고, 
강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (1 ≤ L ≤ 1,000,000) 강산이가 백스페이스를 입력했다면, 
'-'가 주어진다. 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다. 
화살표의 입력은 '<'와 '>'로 주어진다. 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다. 
나머지 문자는 비밀번호의 일부이다. 
물론, 나중에 백스페이스를 통해서 지울 수는 있다. 
만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.

출력
각 테스트 케이스에 대해서, 강산이의 비밀번호를 출력한다. 비밀번호의 길이는 항상 0보다 크다.

2
AB<CD
ABC<<DE

ACDB
ADEBC
-----------
2
<<BP<A>>Cd-
ThIsIsS3Cr3t

BAPC
ThIsIsS3Cr3t
 */
public class BJ_silver2_5397_키로거_스택 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>(); 
		Stack<Character> tmp = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i =0 ; i < N;i++) {
			stack = new Stack<>(); 
			tmp = new Stack<>();
			String s = br.readLine();
			int len = s.length();
			for(int j=0;j<len;j++) {
				char now = s.charAt(j);
				int sLen = stack.size();
				int tLen = tmp.size();
				if(now == '<') {
					if(sLen != 0) tmp.push(stack.pop());
				}
				else if(now == '>') {
					if(tLen != 0) stack.push(tmp.pop());
				}
				else if(now == '-') {
					if(sLen !=0) stack.pop();
				}
				else stack.push(now);
			}
			for(Character ss : stack)sb.append(ss);
			while(!tmp.isEmpty()) {
				sb.append(tmp.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
