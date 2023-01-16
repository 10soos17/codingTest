package coding_naver;

//https://www.youtube.com/watch?v=QGsmvwCIAks&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=43
public class RGBDistance42DP {
	static boolean visited[][];	
	static int cnt;
	public static void main(String[] args) {
		int sizeOfMatrix = 6;
		

		int[][] arr = {
						{0, 1, 1, 0, 0, 0},
						{0, 1, 1, 0, 1, 1},
						{0, 0, 0, 0, 1, 1},
						{0, 0, 0, 0, 1, 1},
						{1, 1, 0, 0, 1, 0},
						{1, 1, 1, 0, 0, 0}
						};
		
		solution(sizeOfMatrix, arr);
	}
	
	public static void solution(int sizeOfMatrix, int[][]board) {
//		boolean [][]visited = new boolean[sizeOfMatrix][sizeOfMatrix];
//		
//		for(int i=0;i<sizeOfMatrix;i++) {
//			int x += 
//			for(int j=0;j<sizeOfMatrix;j++) {
//				if(!visited[i][j] && board[i][j] == 1) {
//					solution(board,)
//				}
//				
//			}
//		}
		
		

}
}
