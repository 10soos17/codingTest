package newCoding1010;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27497
/*
입력
첫째 줄에 버튼을 누른 횟수 
$N$이 주어진다. 
$(1 \leq N \leq 1\,000\,000)$ 

둘째 줄부터 
$N$개의 줄에는 버튼을 누른 순서대로 누른 버튼에 대한 정보를 주며 아래와 같은 형식으로 주어진다.

1 c : 문자열 맨 뒤에 c가 적힌 블록 추가
2 c : 문자열 맨 앞에 c가 적힌 블록 추가
3 : 문자열을 구성하는 블록 중 가장 나중에 추가된 블록 제거
c는 알파벳 대문자 또는 소문자로 주어진다.

출력
완성된 문자열을 출력한다. 완성된 문자열이 빈 문자열인 경우 0을 출력한다.

5
1 a
2 b
1 c
3
3

a
 */
public class BJ_silver2_27497_알파벳블록_스택 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Character> stackF = new Stack<>(); 
		Stack<Character> stackB = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[1000001];	// 뒤:true, 앞:false
		int idx = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int action = Integer.parseInt(st.nextToken());
			if(action == 3) {
				if(idx > 0) {
					idx--;
					if(check[idx]) stackB.pop();
					else stackF.pop();
				}
			}else {	
				char text = st.nextToken().charAt(0);
				if(action == 1) {
					stackB.push(text);
					check[idx] = true;
					
				}
				if(action == 2) {
					stackF.push(text);
					check[idx] = false;
				}
				idx++;
			}
		}
		// ***** remove 느림 -> 사용하지말기
		//while(!stackF.isEmpty()) sb.append(stackF.pop());
		//while(!stackB.isEmpty()) sb.append(stackB.remove(0));
        if(stackF.isEmpty() && stackB.isEmpty()) System.out.println(0);
        else {
            while (!stackF.isEmpty()) sb.append(stackF.pop());
            int size = stackB.size();
            for (int i = 0; i < size; i++) sb.append(stackB.get(i));
            System.out.println(sb.toString());
        }
    
	}
}
