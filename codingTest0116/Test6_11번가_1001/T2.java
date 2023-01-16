package Test6_11번가_1001;

import java.util.*;

class T2 {

//	static int r = 3;
//	static int[] l = { 1,2,7,6,4};
//	static int sum=0;
//	static int cnt=0;
	public static void main(String[] args) {

		String s = "hello";
		
		int n = 5;
		int m = 24;
		int p = 4;

		int[] l = { 2, 4};
		int[] ll = { 1,3,5 };
		
		String[] sl = { };
		String[] sll = { };

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };
		
		String res = solution(s);
		System.out.println(res);

	}
	//97-122
	 static String solution(String S) {
	        int[] occurrences = new int[26];
	        for (char ch : S.toCharArray()) {
	            occurrences[ch - 'a']++;
//	            System.out.println(ch - 'a');
//	            System.out.println(ch+"");
	        }

	        char best_char = 'a';
	        int  best_res  = 0;

	        for (int i = 0; i < 26; i++) {
	        	 // System.out.println(occurrences[i]);
	        	//  System.out.println(S.charAt(i)+"");
	            if (occurrences[i] > best_res) {
	                best_char = (char)((int)'a' + i);
	                best_res  = occurrences[i];
	                System.out.println(best_char);
	            }
	        }

	        return Character.toString(best_char);
	    }

}