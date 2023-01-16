package newCoding0423;

import java.util.ArrayList;

//437674	3	3
//110011	10	2
//1 ≤ n ≤ 1,000,000
//3 ≤ k ≤ 10
public class T1_primeNum4 {
	public static void main(String[] args) {
		int n = 437674;
        int k = 3;
        int res = solution(n,k);
       //System.out.print(res+" ");

	}
	
    public static int solution(int n, int k) {
        int answer = 0;
        String number = k == 10 ? String.valueOf(n) : check(n,k);
    	
    	String[] nums = number.split("0+");
    	
    	for(String i : nums) {
    		if(primeCheck(Integer.parseInt(i))) answer++;
    		//System.out.print(i+" ");
    	}

        return answer;
    }
    
    public static String check(int n, int k) {
    	int num = n/k, remainder=n%k;
    	if(num !=0)return check(num, k) + String.valueOf(remainder);
    	else return String.valueOf(remainder);
    }
    public static Boolean primeCheck(int num) {
    	if(num == 2)return true;
    	if(num == 1 || num % 2 == 0)return false;

    	for(int i=2;i<(int)num/2;i++) {
    		if(num%i == 0) return false;
    	}
    	return true;
    }
}
