package newCoding0628_level1;

public class T31_calDartGame {
	public static void main(String[] args) {
		int n = 5;
		int[] nl = {2, 1, 2, 6, 2, 4, 3, 3};

		String s = "1D2S#10S";
		int res = solution(s);
		System.out.println(res);
	}

	public static int solution(String s) {
		int answer=0;

		String[] sl = s.split("");
		int[] sum = new int[3];
		System.out.println(sum.length);
		int nowSum = 0;
		int cnt=0;

		for(int i=0;i<sl.length;i++) {

			if(sl[i].equals("*")) {
				sum[cnt-1]*=2;
				if(i!=2)sum[cnt-2]*=2;
				//System.out.println("*"+sum[cnt-1]);
				continue;
			}
			if(sl[i].equals("#")) {
				sum[cnt-1]*=(-1);
				//System.out.println("#"+sum[cnt-1]);
				continue;
			}

			if(sl[i].equals("S")) {
				int n  = Integer.parseInt(sl[i-1]);
				if(sl[i-1].equals("0")){
					n  = Integer.parseInt(sl[i-2]+sl[i-1]);
				}
				sum[cnt]=n;
				//System.out.println(n+"S"+sum[cnt]);
				cnt++;
			}
			else if(sl[i].equals("D")) {
				int n  =Integer.parseInt(sl[i-1]);
				if(sl[i-1].equals("0")){
					n  = Integer.parseInt(sl[i-2]+sl[i-1]);
				}
				sum[cnt]=(int)Math.pow(n, 2);
				//System.out.println(n+"D"+sum[cnt]);
				cnt++;
			}
			else if(sl[i].equals("T")) {
				int n  =Integer.parseInt(sl[i-1]);
				if(sl[i-1].equals("0")){
					n  = Integer.parseInt(sl[i-2]+sl[i-1]);
				}
				sum[cnt]=(int)Math.pow(n, 3);
				//System.out.println(n+"S"+sum[cnt]);
				cnt++;

			}

		}

		for(int i:sum) {
			//System.out.println(i);
			answer+=i;
		}

		return answer;
	}

}
