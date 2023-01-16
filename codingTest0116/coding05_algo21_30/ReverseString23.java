package coding05_algo21_30;


//문자열 뒤집기 
//https://www.youtube.com/watch?v=iYMY8bBnt2s&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=24
public class ReverseString23 {

	public static void main(String[] args) {
		
//		String n = "ADEFH123"; // -> HFEDA 팰린드롬 풀었던 방식 활용 
//		
//		char str[] = n.toCharArray();
//		char tmp;
//		
//		int len = str.length;
//		
//		for(int i = 0; i < len/2 ; i++) {
//			tmp = str[i];
//			str[i] = str[len-i-1];
//			str[len-i-1] = tmp;
//			
//		}
//		
//		n = new String(str);
//		
//		System.out.println(n);
		
		String s = "ADEFH123";
		String list[] = s.split("");
		String reverse = "";
		for(int i=0;i<list.length;i++) {
			reverse += list[list.length-1-i];
		}
		System.out.println(reverse);
		
		
		
	}

}
