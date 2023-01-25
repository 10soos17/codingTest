package coding_BaekJoon;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=atTzqxbt4DM&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=5
//https://www.acmicpc.net/problem/15694
//순열의 경우

//아이디어
//-백트래킹 재귀함수 안에서, for 돌면서 숫자 선택(이때 방문여부 확인)
//-재귀함수에서 M개를 선택할 경우, print
public class BackTracking {

	static int n;
	static int m;
	static int each;
	static ArrayList<Integer> list;
	static boolean[] check;

	public static void main(String[] args) {

		n = 4;
		m = 2;

		list = new ArrayList<>();
		check = new boolean[n + 1];// index를 1부터 쓰려고 개수 +1로 잡음
		backTracking(0);

	}

	public static void backTracking(int num) {

		if(num == m) {
			System.out.print(list.toString());
			return;
		}
		for(int i=1;i<check.length;i++) {
			if(!check[i] ) {
				check[i] = true;
				list.add(i);
				backTracking(num+1);
				check[i] = false;
				list.remove(list.size()-1);

			}
		}
	}

}
