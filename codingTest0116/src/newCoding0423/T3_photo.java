package newCoding0423;

public class T3_photo {

//		n	data	answer
//		2	["N~F=0", "R~T>2"]	3648
//		2	["M~C<2", "C~M>1"]	0
	static int n = 2;
	static String[] name = { "A", "C", "F", "J", "M", "N", "R", "T" };
	static String[] data = { "N~F=0", "R~T>2" };
	static boolean[] visited = new boolean[name.length];
	static int res=0;

	public static void main(String[] args) {
		//String[] datas= {"N~F=0", "R~T>2"};
		//data = datas.clone();
		int res = solution("");
		//System.out.println(res);
		System.out.println(res);

	}

	public static int solution(String answer) {

		if(answer.length() == name.length) {
			if(check(answer)) {
				res++;
				System.out.println(answer);

			}
			//System.out.println(answer);
			return res;
		}

		for(int i=0; i<name.length;i++) {

			if(!visited[i]) {
				visited[i]=true;
				String text = answer+name[i];
				solution(text);
				visited[i]=false;
			}

		}

		return res;

	}

	public static boolean check(String answer) {
		//N~F=0

		for(String s : data) {
			String t = ""+s.charAt(0);
			String tt= ""+s.charAt(2);
			String opp = ""+s.charAt(3);
			int v = Integer.parseInt(""+s.charAt(4))+1;
			int vv = Math.abs(answer.indexOf(t)-answer.indexOf(tt));

			if(opp.equals("=")&& v != vv) {
				return false;
			}else if(opp.equals(">")&&v >=vv) {
				return false;
			}else if(opp.equals("<")&&v <=vv) {
				return false;
			}

		}

		return true;
	}
}