package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/* 
https://level.goorm.io/exam/49076/1%EC%B0%A8%EC%9B%90-%EB%BF%8C%EC%9A%94%EB%BF%8C%EC%9A%94/quiz/1
9 2
ABCCBCCDA

ADA
===
10 3
ABCCCBBAAA

CLEAR!
*/
public class Goorm_1차원뿌요뿌요_스택 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String S = br.readLine();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			char now = S.charAt(i);
			
			if(stack.size() >= M && stack.get(stack.size()-1) != now) {
				boolean flag = true;
				int idx = 0;
				for(int j = stack.size()-1; j > 1; j--) {
					System.out.println("check:"+j);
					idx++;
					if(stack.get(j) != stack.get(j-1)) {						
						System.out.println("checkxxxx:"+j+"idx"+idx);
						flag = false;
						if(idx >= M) flag = true;
						break;
					}
					
				}
				System.out.println("checkend====================");
				if(flag) for(int j=0; j < idx; j++) stack.pop();
			}
			stack.push(now);
		}
		
		if(stack.size() == 0) System.out.println("CLEAR!"); 
		else for(char s : stack) sb.append(s);
		System.out.print(sb.toString());
	}
}
