package coding08_kakao;

//https://www.youtube.com/watch?v=ExaatgwYqfU&list=PL2lVRutSfJd-aUSEkdMO8QbRuL5tPOrie
public class BitCal01 {

	public static void main(String[] args) {

//		Scanner s = new Scanner(System.in);
//
//
//		System.out.println("값 입력해라. ");
//		int n = s.nextInt();
//		while(1>n || n > 16) {
//			n = s.nextInt();
//			System.out.println("1~16입력해라. ");
//		}
//		System.out.println("입력값: "+n);
//		int[] firstArr = new int[n];
//		int[] secondArr = new int[n];
//
//		System.out.println("첫번째 배열 값 "+n+"개 입력해라. ");
//		for(int i=1; i<n+1;i++) {
//			firstArr[i-1] = s.nextInt();
//			System.out.println("첫번째 배열의 "+i+"번째 값 :"+firstArr[i-1]);
//		}
//		System.out.println("두번째 배열 값 "+n+"개 입력해라. ");
//		for(int i=1; i<n+1;i++) {
//			secondArr[i-1] = s.nextInt();
//			System.out.println("두번째 배열의 "+i+"번째 값 :"+secondArr[i-1]);
//		}

		int n=5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};

		String[]answer = new String[n];

        for(int i=0;i<n;i++){
            int res = arr1[i] | arr2[i];
            String bin = Integer.toBinaryString(res);
            answer[i] = bin;
            answer[i] = String.format("%" + n + "s", answer[i]);
            answer[i] = answer[i].replaceAll("1","#");
            answer[i] = answer[i].replaceAll("0"," ");
        }
		for(int i=0;i<n;i++) {
			System.out.println(answer[i]);
		}


	}

}
