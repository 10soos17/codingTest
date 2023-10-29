package coding05_algo21_30;

//https://www.youtube.com/watch?v=DH18W_oII6U&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=27
public class Constant26 {

	public static void main(String[] args) {

//		int a = 734;
//		int b = 893;
//
//		int arrA[] = new int [3];
//		int arrB[] = new int [3];
//
//		int lenA = 0;
//		do {
//			arrA[lenA] = a % 10;
//			a/=10;
//			lenA++;
//		}while(a>0);
//
//		int tranA = 0;
//		int mux = 1;
//		for(int i=arrA.length-1;i>=0;i--) {
//			tranA += arrA[i]*mux;
//			mux*=10;
//		}
//		System.out.println("tranA="+tranA);
//
//		int lenB = 0;
//		do {
//			arrB[lenB] = b % 10;
//			b/=10;
//			lenB++;
//		}while(b>0);
//
//		int tranB = 0;
//		mux = 1;
//		for(int i=arrB.length-1;i>=0;i--) {
//			tranB += arrB[i]*mux;
//			mux*=10;
//		}
//		System.out.println("tranB="+tranB);
//
//		if(tranA > tranB) {
//			System.out.println("큰 수: "+tranA);
//		}else if(tranA < tranB) {
//			System.out.println("큰 수: "+tranB);
//		}else {
//			System.out.println("두 수 같음");
//		}

		int a = 734;
		int b = 893;


		int [] arr1 = new int[3];
		int [] arr2 = new int[3];

		int cnt =0;


		while(a>0) {
			arr1[cnt] = a%10;
			a/=10;
			cnt++;
		}

		String str = "";
		for (int element : arr1) {
			str+=String.valueOf(element);

		}

		System.out.println(str);

		cnt=0;
		while(b>0) {
			arr2[cnt] = b%10;
			b/=10;
			cnt++;
		}

		int mul = 1;
		int res=0;
		for(int i=arr2.length-1;i>=0;i--) {
			res+=arr2[i]*mul;
			mul*=10;
		}

		System.out.println(res);

	}


}
