package coding_AlgoBasic;

import java.util.Arrays;
import java.util.Stack;

//https://www.youtube.com/watch?v=eu9ttD-psU4&list=PLDV-cCQnUlIYQOb8_n-d-VPhl_X6cECjg&index=2
//문제: '( ) { } [ ]' 로 이루어진 괄호쌍들이 valid한지 판별하여라
public class Stack1 {

	public static void main(String[] args) {

		String[] arr = {"(){}[]", "{([])}", "({)(})"};
		int target = 16;
		solution(arr);
		
	}

	
	public static void solution(String[] arr) {
		
		boolean answer[] = new boolean[arr.length];

		Stack<String> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			String[] list = arr[i].split("");
			
			for(String s: list) {
				if(s.equals("(") || s.equals("{") || s.equals("[") ) {
					stack.push(s);
				}else {
					if(isValid(s).equals(stack.get(stack.size()-1))) {
						stack.pop();
					}else {
						answer[i] = false;
						break;
					}
				}
				
			}
			if(stack.size() == 0) {
				answer[i] = true;
			}else {
				answer[i] = false;
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
	public static String isValid(String s) {
		
		String str="";
		if(s.equals(")")) {
			str="(";
		}if(s.equals("}")) {
			str="{";
		}if(s.equals("]")) {
			str= "[";
		}
		return str;
	}

}
