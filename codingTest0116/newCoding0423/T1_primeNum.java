package newCoding0423;

import java.util.ArrayList;

//437674	3	3
//110011	10	2
//1 ≤ n ≤ 1,000,000
//3 ≤ k ≤ 10
public class T1_primeNum {
	public static void main(String[] args) {
		int n = 437674;
        int k = 3;
        int res = solution(n,k);
        System.out.print(res+" ");

	}

    public static int solution(int n, int k) {
        int answer = 0;
        ArrayList<Integer> s = new ArrayList<>();

        while(n>=k){
        	s.add(n%k);
        	n=n/k;
        }
        s.add(n);
        //System.out.println(s);

        ArrayList<Integer> nums = check(s);
        for(int i : nums) {
        	Boolean res = primeCheck(i);
        	if(res)answer++;
        }
        return answer;
    }

    public static ArrayList<Integer> check(ArrayList<Integer> list) {
    	String s="";
    	ArrayList<Integer> nums = new ArrayList<>();

    	for(int i=list.size()-1;i >= 0;i--) {
    		if(list.get(i) == 0 && s!="") {
    			System.out.println(s);
    			nums.add(Integer.parseInt(s));
    			s="";
    			continue;
    		}
    		s+=list.get(i);
    	}
    	nums.add(Integer.parseInt(s));
//    	for(int i : nums) {
//    		System.out.print(i+",");
//    	}
    	return nums;
    }

    public static Boolean primeCheck(int num) {
    	if(num == 1)return false;
    	if(num == 2)return true;
    	int i = num-1;
    	while(i>1) {
    		if(num%i == 0) return false;
    		i-=1;
    	}
    	return true;
    }
}

