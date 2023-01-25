package coding03_algo1_13;

//팩토리얼 계산
//https://www.youtube.com/watch?v=7wIUlCM8v9k&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=9
public class Factorial {

	public static void main(String[] args) {

//		//1.
//		int num = 5;
//		int result = num;
//
//		for(int i = num-1; i>1; i--) {
//			result *= i;
//		}
//
//		System.out.println(result);

//		//2. Scanner 입력값 받기 + recursion
//		Scanner sc = new Scanner(System.in);
//		int n = 0;
//		boolean flag = true;
//
//		while(flag) {
//			try {
//				System.out.println("input:");
//				n = sc.nextInt();
//				System.out.println("Number:"+ n);
//				flag = !flag;
//			}catch(Exception e) {
//				System.out.println("not a number.");
//				sc.next();
//
//			}
//		}
//		int facto = getFactorial(n);
//		System.out.println("factorial: "+ facto);
//
////		int facto = n;
////
////		for(int i=n-1;i>1;i--) {
////			facto *= i;
////		}
////		System.out.println("factorial: "+ facto);

		int n = 5;

		int res = n;
		for (int i = n - 1; i > 1; i--) {
			res *= i;
		}
		System.out.println(res);

	}

	// recursion
	public static int getFactorial(int num) {

		if (num == 1) {
			System.out.println("exit num:" + num);
			return num;
		}
		return num * getFactorial(num - 1);
	}

}
