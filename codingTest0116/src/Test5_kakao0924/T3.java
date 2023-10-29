package Test5_kakao0924;

import java.util.Arrays;

class T3 {

	static int[] arr = { 10, 20, 30, 40 };
	static int r;
	static int[] tmp;
	static boolean[] visited;
	static int cnt;
	static int[] answer = { 0, 0 };

	public static void main(String[] args) {

		int[][] k = { { 40, 10000 }, { 25, 10000 } };
		int[] kk = { 7000, 9000 };

		// perm(0);
		tmp = new int[kk.length];
		visited = new boolean[arr.length];
		r = kk.length;
		perm(0, k, kk);

		// int[] res = solution(k,kk);
		// System.out.println(res[0]+":"+res[1]);

	}

	static int[] solution(int[][] k, int[] kk) {
		System.out.println("test");
		int sumI=0;
		int cntI=0;

		for (int[] element : k) {

			int sum = 0;

			int myPercent = element[0];
			int myLimit = element[1];

			for (int j = 0; j < kk.length; j++) {

				int percent = tmp[j];
				int price = kk[j];

				if (myPercent < percent)
					continue;
				sum += (100 - percent) * price / 100;
			}
			System.out.println(sum + "++++" + myLimit);
			if (sum > myLimit) {
				cntI++;
			} else {
				sumI += sum;
				sum = 0;
			}
		}

		int[] answer = count(cntI, sumI);



		return answer;
	}



	static void perm(int dep, int[][] k, int[] kk) {

		if (dep == r) {
			System.out.println(Arrays.toString(tmp));
			dep = 0;
			int[] res = solution(k, kk);
			System.out.println(res[0] + ":" + res[1]);
			// return tmp;
		}

		for (int i = 0; i < arr.length; i++) {

			if (!visited[i]) {
				visited[i] = true;
				tmp[dep] = arr[i];
				perm(dep + 1, k, kk);
				visited[i] = false;
			}

		}

	}

	static int[] count(int cnt, int sum) {

		if (answer[0] < cnt) {
			System.out.println("cnt reset");
			answer[0] = cnt;
			answer[1] = sum;
		}else if (answer[0] == cnt) {
			System.out.println("compare sum:"+sum);
			if (answer[1] < sum) {
				System.out.println("reset sum");
				answer[1] = sum;
			}
		}
		return answer;
	}

}

//Map<Integer,ArrayList<Integer>>map = new HashMap<>();
//
//for(int i=0;i<k.length;i++) {
//	int percent = k[i][0];
//	int limit = k[i][1];
//
//	if(map.containsKey(percent)) continue;
//
//	//
//	ArrayList<Integer> list = new ArrayList<Integer>();
//	int cnt = 0;
//	int max = 0;//Integer.MAX_VALUE/2;
//
//	for(int j=0;j<k.length;j++) {
//		int sum=0;
//
//		int thisPercent = k[j][0];
//		int thisLimit = k[j][1];
//
//		if(thisPercent<percent) continue;
//
//		for(int u=0;u<kk.length;u++) {
//			sum+=thisPercent * kk[u]/100;
//		}
//
//		if(sum>thisLimit) cnt++;
//		else {
//			max = Math.max(sum, max);
//		}
//		list.add(cnt);
//		list.add(max);
//
//		cnt=0;
//
//	}
//	map.put(percent, list);
//}
//int c = 0;
//int m = 0;
//for(Integer key : map.keySet()) {
//	ArrayList<Integer> l = map.get(key);
//	if(c < l.get(0)) {
//		c=l.get(0);
//		m=l.get(1);
//	}else if(c==l.get(0)) {
//		m=Math.max(m, l.get(1));
//	}
//}
//answer[0] = c;
//answer[1] = m;
