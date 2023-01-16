package codingTest_pro;

import java.util.ArrayList;
import java.util.HashMap;

public class Dev_Lotto_21_Lv1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr1 = {44, 1, 0, 0, 31, 25};
		int [] arr2 = {31, 10, 45, 1, 6, 19};

		
		solution(arr1, arr2);
	}
	
	
	
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] grade = new int[6];
        
        int cnt=0;
        int correct=0;
        for(int i=0;i<lottos.length;i++) {
        	if(lottos[i] == 0) {
        		cnt++;
        	}else {
	        	for(int j=0;j<win_nums.length;j++) {
	        		if(lottos[i] == win_nums[j] && win_nums[j] != 0) {
	        			win_nums[j] = -1;
	        			lottos[i] = -1;
	        			correct++;
	        			break;
	        		}
	        	}
        	}
        }
        
        answer[1] = correct;
        
      if( 6-correct>=cnt) {
    	  answer[0] = correct+cnt;
      }else{
    	  answer[0] = correct + 6-correct;
      };
      
      
      if(answer[0]==0|| answer[0] == 1) {
    	  answer[0] = 6;
      }else {
    	  answer[0] = 7-answer[0];
      }
      if(answer[1]==0 || answer[1] == 1) {
    	  answer[1] = 6;
      }else {
    	  answer[1] = 7-answer[1];
      }
        
      System.out.println(answer[0]+":"+answer[1]);
        
        
        
        return answer;
    }


}
