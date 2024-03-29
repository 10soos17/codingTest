package coding08_kakao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.youtube.com/watch?v=0DKWXDs1CiA&list=PL2lVRutSfJd-aUSEkdMO8QbRuL5tPOrie&index=4
public class DartGameRegularExpression4_self {

	static int sum[] = new int[3];
	public static void main(String[] args) {


		//ex. 1S2D*3T - 37 (1^1 * 2 + 2^2 * 2 + 3^3)

		run("1S2D*3T");
//		run("1D2S#10S");
//		run("1D2S0T");
//		run("1S*2T*3S");
//		run("1D#2S*3S");
//		run("1T2D3D#");
//		run("1D2S3T*");




	}
	public static void run(String msg) {

		String regex = "(\\d{1,2}[S|T|D][*|#]{0,1})";
		Pattern p = Pattern.compile(regex + regex + regex);
		Matcher m = p.matcher(msg);
		m.find();

//		System.out.println(m.groupCount());
//		System.out.println(m.group(3));

		for(int i=1;i<=m.groupCount();i++) {

			Pattern p1 = Pattern.compile("(\\d{1,2})([S|T|D])([*|#]{0,1})");
			Matcher m1 = p1.matcher(m.group(i));
			m1.find();

			sum[i-1] = (int)Math.pow(Integer.parseInt(m1.group(1)), getPow(m1.group(2)));

			if(m1.group(3) != null) {
				setOption(i,m1.group(3));
				//System.out.println(m1.group(3));
			}



		}

		System.out.println(msg + " - " + (sum[0]+sum[1]+sum[2]));
	}

	public static void setOption(int idx, String m) {

		if("*".equals(m)) {
			sum[idx -1] *=2;
			if(idx > 1) {//첫번째 아닐경우, 그 점수 + 이전점수 2배
				sum[idx -2] *=2;
			}
		}else if("#".equals(m)) {
			sum[idx-1]*=(-1);
		}
	}

	public static int getPow(String m) {
		int val = 0;

		if("S".equals(m)) {
			val = 1;
		}else if("D".equals(m)) {
			val = 2;
		}else if("T".equals(m)) {
			val = 3;
		}

		return val;
	}



}
