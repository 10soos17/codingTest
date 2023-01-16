package newCoding0821_HS;

import java.util.Arrays;

public class PermuCombi {

	static int[] arr = { 1, 2, 3, 4 };
	static int len = arr.length;
	static int[] tmp;
	static boolean[] visited;
	static int cnt;

	static void perm(int dep) {

		if (dep == len) {
			System.out.println(Arrays.toString(tmp));
			cnt++;
			return;
		}

		for (int i = 0; i < len; i++) {

			if (!visited[i]) {
				visited[i] = true;
				tmp[dep] = arr[i];
				perm(dep + 1);
				visited[i] = false;
			}

		}

	}

	static void perm2(int dep) {
		if (dep == len) {
			System.out.println(Arrays.toString(tmp));
			cnt++;
			return;
		}

		for (int i = 0; i < len; i++) {

			tmp[dep] = arr[i];
			perm2(dep + 1);

		}
	}

	static void comb(int dep, int start) {
		if (dep == len) {
			System.out.println(Arrays.toString(tmp));
			cnt++;
			return;
		}

		for (int i = start; i < len; i++) {

			tmp[dep] = arr[i];
			comb(dep + 1, i + 1);
			

		}

	}

	static void comb2(int dep, int start) {
		   if(dep==len) {
			   System.out.println(Arrays.toString(tmp));
			   cnt++;
			   return;
		   }
		   
		   
		   for(int i=start;i<len;i++) {
			   		
				   tmp[dep] = arr[i];
				   comb2(dep+1,i);
			   
		   }
		
	}

	public static void main(String[] args) {
		tmp = new int[arr.length];
		visited = new boolean[arr.length];
		// perm(0);
		// perm2(0);
		//comb(0,0);
		comb2(0,0);
		System.out.println("총 개수 : " + cnt);

	}

}