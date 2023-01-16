package coding07_algo41_50;

import java.util.Scanner;

public class CrossArray11 {
	static int row, col, sr, sc;
	static int[][] board = new int [100][100];

	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);
//		row = scan.nextInt();
//		col = scan.nextInt();
//		for(int i=0;i<row;++i) {
//			for(int j=0;j<col;j++) {
//				board[i][j] = scan.nextInt();
//			}
//		}
//		sr = scan.nextInt();
//		sc = scan.nextInt();
		row=5;
		col=5;
		sr=1;
		sc=1;
		int[][] board = {{0,0,0,0,0},
				{0,0,0,2,0},
				{0,0,0,0,0},
				{2,2,2,0,0},
				{0,0,0,0,0}};
		
		cross(board,sr,sc);
		
	}
	public static void cross(int[][] board, int sr, int sc) {
		
		if(board[sr][sc] != 0) {
			return;
		}
		board[sr][sc] = 1;
		for(int i=sr-1;i>=0;i--) {//위 
			if(board[i][sc] != 0)break;
			board[i][sc] = 1;
		}
		
		for(int i=sr+1;i<row;i++) {//아래 
			if(board[i][sc] != 0)break;
			board[i][sc] = 1;
		}
		for(int i = sc-1;i>=0;i--) {//왼쪽 
			if(board[sr][i] != 0)break;
			board[sr][i] = 1;
		}
		for(int i=sc+1;i<col;i++) {//오른쪽 
			if(board[sr][i] != 0)break;
			board[sr][i] = 1;
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println("");
			}
		
	}
}
