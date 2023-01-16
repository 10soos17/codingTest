package newCoding0423;

import java.util.ArrayList;

//437674	3	3
//110011	10	2
//1 ≤ n ≤ 1,000,000
//3 ≤ k ≤ 10
public class T1_primeNum3 {
	public static void main(String[] args) {
		int n = 437674;
        int k = 3;
        int res = solution(n,k);
       //System.out.print(res+" ");

	}
	
    public static int solution(int n, int k) {
        int answer = 0;
        String s = "";
        
        if (n == 10) s= String.valueOf(n);
        else {
	        while(n>=k){
	        	s+=n%k;
	        	n=n/k;
	        }
	        s+=n;
        }
        //System.out.println(s);
        String reversedString = new StringBuilder(s).reverse().toString();
    	
    	String[] nums = reversedString.split("0");
    	for(String i : nums) {
    		if(i.equals("")) continue;
    		Boolean res = primeCheck(Integer.parseInt(i));
    		if(res)answer++;
    		//System.out.print(i+" ");
    	}

        return answer;
    }
    
    
    public static Boolean primeCheck(int num) {
    	if(num == 2)return true;
    	if(num == 1 || num % 2 == 0)return false;

    	for(int i=2;i<num/2;i++) {
    		if(num%i == 0) return false;
    	}
    	return true;
    }
}
