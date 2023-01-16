package newCoding0628_level1;

class T14_plusDevisor {
//	정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴
//	n	return
//	12	28
//	5	6
	public static void main(String[] args) {
		int n =12;
		// int m = 5;
		int res = solution(n);

		System.out.println(res);
		// System.out.println(res[0]+":"+res[n.length-2]);

	}

	public static int solution(int num) {

    	int answer=0;
    	int limit =num;
    	
    	if(num % Math.sqrt(num) ==0) answer += Math.sqrt(num);   	
    	if(num == 1) return 1;
    	
    	while(limit>Math.sqrt(num)+1){
    		
    		if(num%limit==0) {
    			answer+=limit;
    			System.out.println(limit+":"+answer);
    			answer+=num/limit;
    			System.out.println(":"+answer);
    		}
    		
    		limit-=1;
    		
    	}
    	
    	return answer;
		
	}

}