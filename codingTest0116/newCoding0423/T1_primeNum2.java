package newCoding0423;

import java.util.ArrayList;

//437674	3	3
//110011	10	2
//1 ≤ n ≤ 1,000,000
//3 ≤ k ≤ 10
public class T1_primeNum2 {
	public static void main(String[] args) {
		int n = 437674;
        int k = 3;
        int res = solution(n,k);
       System.out.print(res+" ");

	}
	
    public static int solution(int n, int k) {
        int answer = 0;
        String s = "";
        while(n>=k){
        	s+=n%k;
        	n=n/k;
        }
        s+=n;
        System.out.println(s);
        answer = check(s);

        return answer;
    }
    
    public static int check(String number) {
    	int answer=0;
    	String s="";
    	String[] list = number.split("");
    	for(int i=list.length-1;i>=0;i--) {
    		s+=list[i];
    	}
    	
    	String[] nums = s.split("0");
    	for(String i : nums) {
    		if(i.equals("")) continue;
    		Boolean res = primeCheck(Integer.parseInt(i));
    		if(res)answer++;
    		System.out.print(i+" ");
    	}
    	return answer;
    }
    
    public static Boolean primeCheck(int num) {
    	if(num == 1)return false;
    	if(num == 2)return true;
    	int i = (int)Math.sqrt(num);
    	while(i>1) {
    		if((Math.sqrt(num)+1)%i == 0) return false;
    		i-=1;
    	}
    	return true;
    }
}
