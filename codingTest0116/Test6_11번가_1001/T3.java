package Test6_11번가_1001;

class T3 {

//	static int r = 3;
//	static int[] l = { 1,2,7,6,4};
//	static int sum=0;
//	static int cnt=0;
	public static void main(String[] args) {

		String s = "ONLABLABLOON";
		String ss = "BALLOON";
		int n = 5;
		int m = 24;
		int p = 4;

		int[] l = { 2, 4};
		int[] ll = { 1,3,5 };

		String[] sl = { };
		String[] sll = { };

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };

		int res = solution(s,ss);
		System.out.println(res);

	}

    //65-90
    //65/66/76/78/79
    //A1 B1 L2 N1 O2
	static int solution(String s, String ss) {
        int answer = 0;

        int[] check = new int[15];
        boolean flag = false;

        for(int i=0;i<s.length();i++) {
        	//String text = s.charAt(i)+"";
        	int idx = s.charAt(i)-65;

        	if(!flag && idx != 0 && idx != 1 && idx != 11 && idx !=13 && idx !=14) {
        		flag = true;
        		answer++;
        		continue;
        	}
        		else if(idx == 0) check[idx]++;
        		else if(idx == 1) check[idx]++;
        		else if(idx == 11) check[idx]++;
        		else if(idx == 13) check[idx]++;
        		else if(idx == 14) check[idx]++;
        	flag = false;


        }

       if((check[0]<1) || (check[1]<1) || (check[11]<2) || (check[13]<1)) return 0;
       if(check[14]<2) return 0;
       System.out.println("test");
       return answer;

	}
}