package newCoding0523;

import java.util.Arrays;

//주어진 수가 1이 될때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.
//
//1-1. 입력된 수가 짝수라면 2로 나눕니다. 
//1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
//2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
//
//n	result
//6	8
//16	4
//626331	-1
public class T17_collatzConjecture {
	public static void main(String[] args) {

		int num = 16;

		int answer = solution(num);
		System.out.println(answer);

	}

	public static int solution(int num) {
		int answer = 0;

		while(num != 1){
	        if(num % 2 == 0){
	        num /= 2;
	      } else{
	        num = num * 3 + 1;
	      }
	      answer++;
	      if(answer == 500){
	        return -1;
	      }
	    }
	        return answer;
	    
	}

}
