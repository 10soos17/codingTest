package newCoding0821_HS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1018

public class T_BJ_paintChess1018 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char [][] map = new char[N][M];

		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();


		int cntW = 0;
		int cntB = 0;
		int ans = 987654321;
		char chk = 'W'; //

		boolean check = false; // B


		for(int k=0; k<N-8+1;k++) {
			for(int l=0; l<M-8+1;l++) {

				cntW = 0; cntB= 0;

				for(int i=k; i < 8+k; i++) {
					for(int j=l ; j < 8+l; j++) {
						if(!check) {
							if(map[i][j]=='W') cntB++;
						}else {
							if(map[i][j]=='B') cntB++;
						}
						check = !check;
						if(!check) {
							if(map[i][j]=='W') cntW++;
						}else {
							if(map[i][j]=='B') cntW++;
						}

					}
					check = !check;
				}
				ans = Math.min(ans, Math.min(cntW, cntB));
			}
		}

		System.out.println(ans);

	}
}
