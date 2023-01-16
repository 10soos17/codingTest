package newCoding0628_level1;

class T12_pluesDigit {
//	자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return
//	예를들어 N = 123이면 1 + 2 + 3 = 6을 return
//			N	answer
//			123	6
//			987	24
	public static void main(String[] args) {
		long n = 987;
		//int m = 5;
		long res = solution(n);

		System.out.println(res);
		//System.out.println(res[0]+":"+res[n.length-2]);

	}
	//답안1
    public static long solution(long n) {
    	
    	long answer = 0;
    	
    	while(n>0) {
    		answer+=n%10;
    		n/=10;
    	}
    

		return answer;
	}
    //답안2
	/*String[] num = String.valueOf(n).split("");
	
	for(String s : num) {
		answer+=Integer.parseInt(s);
	}*/
   
}