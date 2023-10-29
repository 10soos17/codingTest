package coding03_algo1_13;

//소수 판별
//소수 1, 자기 자신을 제외하고 나누어 떨어지는 약수가 있으면 -> 소수가 아님.
//소수 = 1과 자기자신만 나누어떨어지는 것
//https://www.youtube.com/watch?v=CZOkPNGWpDA&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=8

public class PrimeNumber {

	public static void main(String[] args) {
//		int num = 13;
//		boolean isPrimeNumber = true;
//
//		//2부터 for 문, 그 수의 반(num/2)까지 범위
//		for(int i=2;i<= num / 2;i++) {
//			if(num % i == 0) {//primeNumber 가 아님
//				isPrimeNumber = false;
//			}
//		}
//		if(isPrimeNumber) {
//			System.out.println(num + " is PrimeNumber");
//		}else {
//			System.out.println(num + " is not PrimeNumber");
//		}

		int num = 13;
		boolean check = true;



		for(int i=2;i<num/2;i++) {
			if(num%i == 0) {
				check = false;
			}
		}
		if(check) {
			System.out.println(num +"은 소수입니다.");
		}else {
			System.out.println(num +"은 소수가 아닙니다.");

		}


	}

}
