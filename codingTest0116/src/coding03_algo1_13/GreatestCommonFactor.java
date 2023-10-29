package coding03_algo1_13;

public class GreatestCommonFactor {

	public static void main(String[] args) {
		//12 18 -> 6
//
//		int num1, num2;
//
//		num1 = 12;
//		num2 = 18;
//
//		//두 수 중 큰 수 판별
//		int small;
//		int big;
//
//		if(num1 > num2) {
//			big = num1;
//			small = num2;
//		}else {
//			big = num2;
//			small = num1;
//		}
//
//		int gcd = 1; //최대공약수
//
//		//더 작은 수만큼 for문
//		//둘다 나누어 떨어지면 gcd값 그값으로 갱신
//		for(int i=1; i<=small;i++) {
//			if(big%i==0 && small % i == 0) {
//				gcd = i;
//			}
//		}
//		System.out.println(gcd);

		int n1,n2;

		n1=12;
		n2=18;

		int s=0;
		int b=0;

		int gcd=0;

		if(n1>n2) {
			s=n2;
			b=n1;
		}else {
			s=n1;
			b=n2;
		}

		for(int i=1;i<s;i++) {
			if(b%i==0&&s%i==0) {
				gcd=i;
			}
		}
		System.out.println(gcd);

	}

}
