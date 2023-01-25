package coding05_algo21_30;

public class PlusMinusRepeat30 {

	public static void main(String[] args) {
//		int until;
//		Scanner scan = new Scanner(System.in);
//
//		until = scan.nextInt();
//		//int res =0;
//		String str = "1";
//		int n = 2;
//
//
//		while(until >1) {
//
//			if(until%2 !=0) {
//				str += "-" ;
//				str += String.valueOf(n);
//			}else {
//				str += "+" ;
//				str += String.valueOf(n);
//			}
//			until -=1;
//			n+=1;
//		}
//
//		System.out.println(str);

		int until = 10;
		String s = "1";
		int n = 2;
		while(until>=n) {
			if(n %2 ==0) {
				s+="+";
				s+=String.valueOf(n);


			}else {
				s+="-";
				s+=String.valueOf(n);


			}
			n++;
		}
		System.out.println(s);



	}

}
