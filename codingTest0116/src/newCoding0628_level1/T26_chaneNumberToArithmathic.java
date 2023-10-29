package newCoding0628_level1;

//핸드폰 번호 가리기
//phone_number	return
//"01033334444"	"*******4444"
//"027778888"	"*****8888"
class T26_chaneNumberToArithmathic {

	public static void main(String[] args) {


		String n = "027778888";
		int m = 3;
		String res = solution(n);
//		System.out.println(Arrays.toString(res));{

		//for(int i : res) {
		System.out.println(res);
	//	}
	}

	public static String solution(String n) {

		String  answer = n.substring(0, n.length()-4).replaceAll("[0-9]","*");
		answer+=n.substring(n.length()-4,n.length());

		return answer;

	}
}