package coding04_algo14_20;

public class MultipleTable {

	public static void main(String[] args) {
		int s = 2;
		int f = 5;
//		//2~5출력
//
//		for(int i=2;i<6;i++) {
//			for(int j=1;j<10;j++) {
//				System.out.println(i+"*"+j+"="+i*j);
//			}
//		}

		for(int i=s;i<=f;i++) {
			for(int j=1;j<10;j++) {
				System.out.println(i+" * "+j+" = "+ i*j);
			}
		}

	}

}
