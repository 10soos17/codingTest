package codingTest_pro;

import java.util.Arrays;
import java.util.Comparator;

public class hash_phoneList {

	public static void main(String[] args) {
		//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]] ->	[5, 6, 3]
		String [] arr1 = {"12","123","567","88","1235"};//false

		solution(arr1);

	}

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, new Comparator<String>() {

        	@Override
			public int compare(String val1, String val2) {
        		int n1 = val1.length();
        		int n2 = val2.length();

        		return n1-n2;
        	}

        });

        System.out.println(Arrays.toString(phone_book));
       for(int i =0;i<phone_book.length;i++) {
	        	for(int j=i+1;j<phone_book.length;j++) {
	        		String s = phone_book[j].substring(0,phone_book[i].length());
	        		//System.out.println(s);
	        		if(phone_book[i].equals(s)){
	        			//System.out.println(phone_book[j]);
	        			answer =false;
	        			break;

	        		}
	        	}
	        }
        System.out.println(answer);


        return answer;
    }
	}