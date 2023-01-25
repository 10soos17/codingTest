package Test4_line0924;

import java.util.HashMap;
import java.util.Map;

class T2 {

//	static int r = 3;
//	static int[] l = { 1,2,7,6,4};
//	static int sum=0;
//	static int cnt=0;
	public static void main(String[] args) {

		String s = "badword ab.cd bad.ord .word sl.. bad.word";

		int n = 2;
		int m = 24;
		int p = 4;

		int[] l = { 2, 4 };
		int[] ll = { 1, 3, 5 };

		String[] sl = { "slang", "badword" };

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };

		String res = solution1(n, sl, s);
		System.out.println(res);

	}

	static String solution1(int n, String[] sl, String s) {

		String ns = "";

		String[] split = s.split(" ");
		Map<String, Integer> sCnt = new HashMap<>();

		for (String sc : split) {
			String fir = sc.charAt(0) + "";
			String sec = sc.charAt(sc.length() - 1) + "";

			int cnt = 0;

			for (int j = 0; j < sc.length(); j++) {
				if ((sc.charAt(j) + "").equals(".")) {
					cnt++;
				}
				if (cnt > n) {
					ns += sc + " ";
					break;
				}
			}
			if (cnt > n)
				continue;
			else if(cnt <= n && fir.equals(".") || sec.equals(".")) {
				sCnt.put(sc,cnt);
			}

			boolean check = false;

			for (String element : sl) {

				for(String ss : sCnt.keySet()) {
					String c = sc.replaceAll("[.]", "");
					int idx = element.indexOf(c)-sCnt.get(ss);
					int idxx =sCnt.get(ss)-element.length()-element.indexOf(c)+c.length();
					if(element.contains(c)) {
						if(((ss.charAt(0)+"").equals(".") && idx>1) || ((ss.charAt(ss.length()-1)+"").equals(".") && idxx>1)) {
							ns+=sc.replaceAll(".", "#") + " ";
							check=true;
							break;
						}

					}

				}

				if(check) break;

			}

		}

		return ns;
	}



	static String solution(int n, String[] sl, String s) {
		String ns = "";
		String[] split = s.split(" ");

		for (String sc : split) {
			int cnt = 0;
			for (int j = 0; j < sc.length(); j++) {
				if ((sc.charAt(j) + "").equals(".")) {
					cnt++;
				}
				if (cnt > n) {
					ns += sc + " ";
					break;
				}
			}
			if (cnt > n)
				continue;

			boolean check = false;

			for (String element : sl) {
				System.out.println(sc);
				System.out.println(element);
				if (element.equals(sc)) {
					ns += sc.replaceAll(".", "#") + " ";
					check = true;
					break;
				} else {
					// System.out.println(sc);
					cnt = 0;
					for (int g = 0; g < sc.length(); g++) {
						// System.out.println(sc);
						String one = sc.charAt(g) + "";
						String two = element.charAt(g) + "";

						String fir = sc.charAt(0) + "";
						String sec = sc.charAt(sc.length() - 1) + "";

						if (fir.equals(".") || sec.equals(".")) {
							String c = sc.replaceAll("[.]", "");
							if (element.contains(c)) {
								check = true;
								ns += sc.replaceAll(".", "#") + " ";
								break;
							}
						}
						if (check)
							break;

						if (!one.equals(two) && !one.equals(".") && sc.length() - 1 != g) {
							ns += sc + " ";
							check = true;
							break;
						} else if (sc.length() - 1 == g || one.equals(".")) {
							check = true;
							ns += sc.replaceAll(".", "#") + " ";
						}
						cnt++;
					}
//        				if(cnt==sc.length()) {
//        					check=true;
//        					ns+=sc.replaceAll(".", "#")+ " ";
//        				}
				}
				cnt = 0;

			}
			if (!check) {
				ns += sc + " ";
			}
		}
		return ns;
	}

}