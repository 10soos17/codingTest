package codingTest_pro;

import java.util.Arrays;

public class sort_Nth_Number {

	public static void main(String[] args) {
		//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]] ->	[5, 6, 3]
		int [] arr1 = {5,1, 5, 2, 6, 3, 7, 4};
		int[][] arr2= {{2, 5, 3},{4, 4, 1},{1, 7, 3}};

		solution(arr1,arr2);

	}

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

       for(int i =0; i<commands.length;i++) {

	    	   int iList[] = Arrays.copyOfRange(array,commands[i][0]-1, commands[i][1]);

	    	   Arrays.sort(iList);
	    	   //System.out.println(Arrays.toString(iList));
	    	   answer[i] =iList[commands[i][2]-1];


       }

       for(int i:answer) {
    	   System.out.println(i);
       }


        return answer;
    }
}
