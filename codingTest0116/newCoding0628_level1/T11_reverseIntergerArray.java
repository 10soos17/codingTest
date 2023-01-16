package newCoding0628_level1;

import java.util.Arrays;

class T11_reverseIntergerArray {
//	자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴 
//	n	return
//	12345	[5,4,3,2,1]
	public static void main(String[] args) {
		long num = 2147483648L;
		System.out.println((int)num);
		int[] res = solution(num);
		System.out.println(Arrays.toString(res));
	}

    public static int[] solution(long num) {

    	int len = String.valueOf(num).length();

    	System.out.println(len);
    	
    	int[] answer = new int[len];
    	int i=0;
    	
    	while(num>0) {
    		answer[i++]=(int)(num%10);
    		num/=10;
    	}
    	
    	return answer;
	}
}