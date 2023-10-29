package coding03_algo1_13;

public class Pibo {

	public static void main(String[] args) {
//		int []arr = new int[100];
//
//		//1.
//		//An
//		//An = An-1 + An-2; n>=3
//		//a1 = 1, a2 = 1
//
//		arr[1] = 1;
//		arr[2] = 1;
//
//		for(int i=3; i<100; i++) {
//			arr[i] = arr[i-1] + arr[i-2];
//		}
//		for(int i=1;i<=10;i++) {
//			System.out.print(arr[i] + " ");
//		}
//
//		//2번째 방법
//		//An
//		//An = An-1 + An-2; n>=3
//		//a1 = 1, a2 = 1
//		int prevPrevNum = 1; //An-2
//		int prevNum =1; //An-1
//		System.out.print(prevPrevNum + " ");
//		System.out.print(prevNum + " ");
//
//		for(int i=3;i<=10;i++) {
//			int nNum = prevPrevNum + prevNum;
//			System.out.print(nNum + " ");
//
//			prevPrevNum = prevNum;
//			prevNum = nNum;
//		}


		//self
		int [] arr = new int[100];
		arr[0] =1;
		arr[1] = 1;
		for(int i=2;i<arr.length;i++) {
			arr[i] = arr[i-2] + arr[i-1];

		}


		//3.recursion
		int pibo = getPibo(100);


	}

	//recursion
	public static int getPibo(int num) {
		if((num == 1) || (num == 2)) {
			return 1;
		}

		return getPibo(num-2) + getPibo(num-1);
	}

}
