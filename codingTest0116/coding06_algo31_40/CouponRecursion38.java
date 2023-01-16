package coding06_algo31_40;

import java.util.Scanner;

//쿠폰 스탬프 
//재귀함수가 크게 필요없는 문제 
//https://www.youtube.com/watch?v=dLlUjmMMKqg&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=39
public class CouponRecursion38 {
	
	public static void doFunc(int coupon, int stamp, int k, int ans) {
		if(coupon > 0) {
			coupon --;
			stamp ++;
			ans ++;
			doFunc(coupon, stamp, k, ans);
		}
		else if(stamp > 0) {
			if(stamp/k > 0) {
				stamp -= k;
				coupon++;
				doFunc(coupon, stamp, k, ans);
			}
		}
	};

	public static void main(String[] args) {
		int k;
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		k = s.nextInt();
		int coupon = n;
		
		doFunc(coupon, 0, k, 0);
		

	}

}
