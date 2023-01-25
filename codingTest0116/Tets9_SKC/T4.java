package Tets9_SKC;

//order by sum(salary) desc

//SELECT distinct experience exp, count(experience) count from assessments group by exp;

class T4 {

//	static int r = 3;
//	static int[] l = { 1,2,7,6,4};
//	static int sum=0;
//	static int cnt=0;
	public static void main(String[] args) {

		String id = "bird100";

		int n = 7;
		int m = 24;
		int p = 4;

		int[] l = { 1,1,2,2,1,1 };
		int[] ll = {2,1,4,5,3,6};

		String[] idList = {"bird99", "bird98", "bird101", "gotoxy"};
		String[] sll = {};

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };

		int res = solution(l, ll);
		System.out.println(res);

	}

	public static int solution(int[] l, int[] ll) {
		int answer = -1;

		for(int i=0; i<l.length;i++) {
			System.out.println(l[i]+":"+l[ll[i]-1]);
			if(l[i] != l[ll[i]-1]) {
				answer++;
			}
		}



		return answer;
	}

}