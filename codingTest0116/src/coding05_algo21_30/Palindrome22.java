package coding05_algo21_30;

//가운데 기준으로 동일한 지
//https://www.youtube.com/watch?v=gByou4ahmXs&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=23
public class Palindrome22 {

	public static void main(String[] args) {

//		// 12321
//		String n = "12321";
//
//		int len = n.length();
//		boolean flag = true;
//		for (int i = 0; i < len / 2; i++) {
//			if(n.charAt(i) != n.charAt(len-i-1)) {
//				flag = false;
//
//			}
//		}
//
//		System.out.println(flag);

		String s = "12321";

		int len = s.length();
		boolean flag = true;

		for(int i=0;i<len/2;i++) {
			if(s.charAt(i) != s.charAt(len-i-1)) {
				flag=false;
			}
		}
		System.out.println(flag);




	}
}
