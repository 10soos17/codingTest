package coding08_kakao;

import java.util.ArrayList;

public class PickupDoll2019 {

	public static void main(String[] args) {

		/*
		 * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
		 * [1,5,3,5,1,2,1,4]
		 * 4
		 */
		int [][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] arr1 = {1,5,3,5,1,2,1,4};

		solution(arr,arr1);
	}

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        //System.out.println(size);
        ArrayList<Integer> pocket = new ArrayList<>();


        for(int i=0;i<moves.length;i++) {
        	//System.out.println(moves[i]);
        	for(int j=0;j<size;j++) {

        		if(board[j][moves[i]-1]  != -1 && board[j][moves[i]-1]  != 0 ) {

        			if(pocket.size() > 0) {

	        			if(pocket.get(pocket.size()-1) == board[j][moves[i]-1]) {
	        				pocket.remove(pocket.size()-1);
	        				answer+=2;


	        			}else {
	        				pocket.add(board[j][moves[i]-1]);

	        			}
        			}else {
        				System.out.println("pocket=0");
        				pocket.add(board[j][moves[i]-1]);

        			}
        			board[j][moves[i]-1] = -1;
        			break;
        		}
        	}
        }

        System.out.println(answer);
        return answer;
    }

}
