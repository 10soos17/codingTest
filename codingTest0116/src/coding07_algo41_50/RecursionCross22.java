package coding07_algo41_50;

public class RecursionCross22 {
	static int n,r,c;
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
		n=5;
		r=1;
		c=1;
		int[][] board = {{0,0,0,0,0},
				{0,0,0,2,0},
				{0,0,0,0,0},
				{2,2,2,0,0},
				{0,0,0,0,0}};

		fill(board,r,c);

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}


	}
	public static void fill(int[][] board, int r, int c) {
		if(r < 0 || r > n-1 || c < 0 || c > n-1) return;

		if(board[r][c] != 0) return;

		board[r][c] = 1;

		fill(board,r-1,c);
		fill(board,r+1,c);
		fill(board,r,c-1);
		fill(board,r,c+1);

	}
}
