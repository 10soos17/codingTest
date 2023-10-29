package codingTest_pro;

import java.util.ArrayList;

public class search_math {

	public static void main(String[] args) {

		//[1,3,2,4,2]	[1,2,3]
		int [] arr1 = {1,2,3,4,5};


		solution(arr1);

	}

	public static ArrayList<Integer> solution(int[] answers) {
		 ArrayList<Integer> answer = new ArrayList<>();

        int[] n1= {1, 2, 3, 4, 5};
        int[] n2= {2, 1, 2, 3, 2, 4, 2, 5};
        int[] n3= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        ArrayList<Integer> hit = new ArrayList<>();
        hit.add(0);
        hit.add(0);
        hit.add(0);
        for(int i=0;i<answers.length;i++) {

        	if(answers[i] == n1[i%n1.length]) {
        		hit.set(0,hit.get(0)+1);

        	}
        	if(answers[i] == n2[i%n2.length]) {
        		hit.set(1,hit.get(1)+1);
        	}if(answers[i] == n3[i%n3.length]) {
        		hit.set(2,hit.get(2)+1);
        	}
        }

        int maxVal =Math.max(hit.get(0),Math.max(hit.get(1), hit.get(2)));

        for(int i=0;i<hit.size();i++) {
	        if( maxVal == hit.get(i)) {
	        	answer.add(i+1);
	        	System.out.println(i+1);
	        }
        }

        return answer;
    }
}