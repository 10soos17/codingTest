package coding_BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//https://www.youtube.com/watch?v=qLkFBk5-HrY&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=10
//https://www.acmicpc.net/problem/11726

//아이디어
/*

 */

public class DP {

	public static void main(String[] args) {

		int n =2;
		solution(n);
	}

	public static void solution(int n) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		rs.add(0);
		rs.add(1);
		rs.add(2);
		for(int i=3;i<n+1;i++) {
			rs.add(rs.get(i-1)+rs.get(i-2)%100007);
		}
		System.out.println(rs.get(n));
	}
}
