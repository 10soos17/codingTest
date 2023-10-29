package newCoding0621;

//지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
//전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
//각각 "지도 1"과 "지도 2"라고 하자.
//지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
//지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
//"지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
//암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
//매개변수	값
//n	5
//arr1	[9, 20, 28, 18, 11]
//arr2	[30, 1, 21, 17, 28]
//출력	["#####","# # #", "### #", "# ##", "#####"]
public class T3_sortNum {
	public static void main(String[] args) {
		int num = 5;
		int[] n = { 9, 20, 28, 18, 1 };
		int[] m = { 30, 1, 21, 17, 28 };
		String[] answer = solution2(num, n, m);
		for (String i : answer) {

			System.out.println(i);
		}
	}

	public static String[] solution(int num, int[] n, int[] m) {
		String[] answer = new String[n.length];
		int cnt = 0;
		for (int i = 0; i < n.length; i++) {
			String one = "";
			String two = "";
			int p = n[i];
			int pp = m[i];
			while (num > cnt) {
				one += p % 2;
				two += pp % 2;
				p /= 2;
				pp /= 2;
				cnt++;
			}
			cnt = 0;
			one = new StringBuffer(one).reverse().toString();
			two = new StringBuffer(two).reverse().toString();
			System.out.println(one + ":" + two);
			n[i] = Integer.parseInt(one) + Integer.parseInt(two);
			answer[i] = String.valueOf(n[i]).replaceAll("1", "#").replaceAll("0", " ").replaceAll("2", "#");
			System.out.println(answer[i]);

		}

		return answer;
	}

	public static String[] solution2(int n, int[] arr1, int[] arr2) {

		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {

			int res = arr1[i] | arr2[i];
			System.out.println(res);
			String bin = Integer.toBinaryString(res);
			System.out.println(bin);

			answer[i] = bin;
			answer[i] = String.format("%" + n + "s", answer[i]);
			answer[i] = answer[i].replaceAll("1", "#");
			answer[i] = answer[i].replaceAll("0", " ");
		}

		return answer;
	}
}
