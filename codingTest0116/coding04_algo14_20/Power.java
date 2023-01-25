package coding04_algo14_20;

//거듭제곱
//https://www.youtube.com/watch?v=vDgJbyT0VuE&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=20
public class Power {

	public static void main(String[] args) {

		//1.
		int n = 5;
		int m = 7;

		int res = 1;

		for(int i=m; i>0; i--) {
			res *=n;
		}
		System.out.println(res);

		//2. library
		double pow = Math.pow(5, 7);
		System.out.println(pow);

	}


}
