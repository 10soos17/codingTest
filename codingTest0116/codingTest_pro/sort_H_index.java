package codingTest_pro;


import java.util.Arrays;

public class sort_H_index {

	public static void main(String[] args) {

		int [] arr1 = {3, 0, 6, 1, 5};//3
		solution(arr1);

	}

	public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);


         for(int i=0;i<citations.length;i++) {
        	int h = citations.length-i;

        	if(h<=citations[i]) {
        		answer=h;
        		break;
        	}
        }
        System.out.println(answer);

        return answer;
    }
}