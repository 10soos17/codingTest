package newCoding1010;

/*
 *https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
n개의 음이 아닌 정수들
이 정수들을 순서를 바꾸지 않고 
적절히 더하거나 빼서 타겟 넘버를 만들
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 
타겟 넘버 target이 매개변수로 주어질 때 
숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
*/

public class Programmers_타깃넘버_부분집합 {
	    int answer;
	    int[] arr;
	    int N;
	    int T;
	    public int solution(int[] numbers, int target) {
	        arr = numbers;
	        N = numbers.length;
	        T = target;
	        dfs(0, 0);
	        return answer;
	    }
	    void dfs(int sum, int dep){
	        if(dep == N){
	            if(sum == T) answer++;
	         return;
	        }
	        dfs(sum + arr[dep], dep + 1);
	        dfs(sum - arr[dep], dep + 1);
	    }
	}
