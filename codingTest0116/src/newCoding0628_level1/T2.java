import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
//https://www.acmicpc.net/status?user_id=soo1017&problem_id=1697&from_mine=1
public class Main{

    public static void main(String []args){


      Scanner sc = new Scanner(System.in);

      	boolean[] b = new boolean[100000];
        int n = sc.nextInt();
		int m = sc.nextInt();

		int answer = 0;

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{n,0});

		while(!q.isEmpty()) {


			int[] c = q.poll();
			int pos = c[0];
			int cnt = c[1];

			b[pos] = true;

			if(pos == m) {
				answer = cnt;
				break;
			}

			int ni = 0;

			for(int i=0;i<3;i++) {
				if(i==0) {
					ni = pos+1;
					if(ni >100000 || b[ni])continue;
				}else if(i==1) {
					ni = pos -1;
					if(ni <0 || b[ni]) continue;
				}else {
					ni = pos *2;
					if(ni > 100000 || b[ni]) continue;

				}

				q.offer(new int[] {ni, cnt+1});

			}

		}

        System.out.println(answer);


    }
}
