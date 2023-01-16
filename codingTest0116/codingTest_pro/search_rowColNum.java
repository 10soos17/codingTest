package codingTest_pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class search_rowColNum {

	public static void main(String[] args) {
		
		//10	2	[4, 3]
		int n= 10;
		int m=2;
		
		
		solution(n,m);
		
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown+yellow;
        int n=2;
        ArrayList<Integer> list = new ArrayList<>();
        while(sum>1) {
        	if(sum%n==0) {
        		list.add(n);
        		sum/=n;
        	}else {
        		n+=1;
        	}
        	
        }
        Collections.sort(list,(a,b)-> b.compareTo(a));
        //yellow가 홀수면 ->가로, 세로 모두 홀수
        //yellow가 짝수면 -> 가로는 짝수, 세로는 홀수 
        //가로가 세로보다 더 클것
        
  
        return answer;
        
    }
}