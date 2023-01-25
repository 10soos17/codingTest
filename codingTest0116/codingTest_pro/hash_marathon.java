package codingTest_pro;

import java.util.Arrays;

public class hash_marathon {

	public static void main(String[] args) {
		//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]] ->	[5, 6, 3]
		String [] arr1 = {"mislav", "stanko", "mislav", "ana"};
		String [] arr2= {"stanko", "ana", "mislav"};

		solution(arr1,arr2);

	}

	  public static String solution(String[] participant, String[] completion) {
	        String answer = "";
	        Arrays.sort(participant);
	        Arrays.sort(completion);

	        for(int i=participant.length-1;i>=0;i--) {
	        	if(participant[i].equals(completion[i-1])) {
	        		continue;
	        	}else {
	        		System.out.println(participant[i]);
	        		answer=participant[i];
	        		break;
	        	}

	        }


	        return answer;
	    }
	}