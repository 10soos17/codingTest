package newCoding1010;

import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/92342
입출력 예
n	info	result
5	[2,1,1,1,0,0,0,0,0,0,0]	[0,2,2,0,1,0,0,0,0,0,0]
1	[1,0,0,0,0,0,0,0,0,0,0]	[-1]
9	[0,0,1,2,0,1,1,1,1,1,1]	[1,1,2,0,1,2,2,0,0,0,0]
10	[0,0,0,0,0,0,0,0,3,4,3]	[1,1,1,1,1,1,1,1,0,0,2]
*/

public class Programmers_양궁대회_ {
	/*
	static int N;
	static int[] INFO;
	static int winSum;
	static List<Integer> WININFO = new ArrayList<>();
	static List<ArrayList<Integer>> list = new ArrayList<>();

	// static int[] list = int[11]{};
	public static void main(String[] args) throws Exception {
		N = 5;
		int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		int[] res = solution(N, info);
		System.out.println(res.toString());

	}

	static int[] solution(int n, int[] info) {
		n = N;
		INFO = info;
		int[] answer = new int[11];
		//List<Integer> answer = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			if (info[i] != 0)
				sum += 10 - i;
		}
		
		for (int i = 0; i < 11; i++) WININFO.add(0);
		comb(0, 0);
		
		for(int i = 0; i < list.size(); i++) {
			ArrayList<Integer> l = list.get(i);
			int newSum = 0; 
			for(int j = 0; j < 11; j++) { 
				if(l.get(j) > INFO[j]) newSum += 10 - j; 
			}
			if(sum > newSum) {
				winSum = Math.max(winSum, newSum);
				if(newSum == winSum) {
					//작은 점수 많은 배열 ...
					for(int k = 10; k >= 0; k--) {
						if(l.get(k) < WININFO.get(k)) {
							break;
						}
						if(l.get(k) > WININFO.get(k)){
							WININFO = l;
							break;
						}
					}	
				}
				else {
					WININFO = l;
				}
			}
		}
		for(Integer i : WININFO) answer[i] = i;
		if(winSum == 0) return new int[] {-1};
		return answer;
	}

	static void comb(int dep, int start) {
		if (dep == N) {
			list.add((ArrayList<Integer>) WININFO);
			for (int i = 0; i < 11; i++) WININFO.add(0);
			return;
		}
		for(int i = start; i <11; i++) {
			int now = WININFO.get(dep);
			WININFO.set(dep, now++);
			comb(dep + 1, i);
		}
		
	}
	*/
	// ======================================================= 답안 
	static int N;
	static int[] apeach;
	static int[] ryan = new int[11];
	static int[] answer;
	static int max;
	public static void main(String[] args) throws Exception {
		int n = 5;
		int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		
		solution(n, info);
		System.out.println(Arrays.toString(answer));

	}	
	static int[] solution(int n, int[] info) {
		N = n;
		apeach = info;
		answer = new int[11];
		dfs(N);
		return max == 0 ? new int[] {-1} : answer;
	}
	static void dfs(int dep) {
		if(dep == 0) {
			calc();
			return;
		}
		
		for(int i = 0; i < 11 && ryan[i] <= apeach[i]; i++) {
			ryan[i]++;
			dfs(dep - 1);
			ryan[i]--;
			
		}
	}
	static void calc() {
		int a = 0; int r = 0;
		for(int i = 0; i < 11; i++) {
			if(apeach[i] == 0 && ryan[i] == 0) continue;
			if(apeach[i] < ryan[i]) r += (10 -i );
			else a += (10 - i);
		}
		int diff = r - a;
		if(max < diff) {
			max = diff;
			for(int i = 0; i < 11; i++) {
				answer[i] = ryan[i];
			}
		}else if(max == diff) {
			for(int i = 10; i <= 0; i--) {
				if(answer[i] > ryan[i]) return;
				if(answer[i] < ryan[i]) {
					for(int j = 0; j < 11; j++) {
						answer[j] = ryan[j];
						return;
					}
				}
			}
		}
	}

}

/*
 * import java.util.*;
class Solution {
     int apeach[],tmp[];
     int[]answer;
     int max;
    public int[] solution(int n, int[] info) {

        apeach = info;
        answer = new int[11];
        tmp = new int[11];
        comb(n);
        return max==0 ? new int[]{-1} : answer;
    }

     void calc(){
        int a = 0; int r = 0;
        for(int i=0;i<11;i++){
            if(apeach[i]==0&&tmp[i]==0) continue;
            if(apeach[i]<tmp[i]) r += (10-i);
            else a += (10-i);
        }
        int diff = r-a;
        if(max<diff){
            max = diff;
            for(int i=0;i<11;i++)answer[i] = tmp[i];
        }else if(max==diff){
            for(int i=10;-1<i;i--) {
                if(answer[i]>tmp[i]) return;
                if(tmp[i]>answer[i]){
                    for(int j=0;j<11;j++)answer[j] = tmp[j];
                    return;
                }
            }
        }
    }

     void comb(int depth){

        if(depth==0){
            calc();
            return;
        }


        for(int i=0;i<11&&tmp[i]<=apeach[i];i++){
            tmp[i]++;
            comb(depth-1);
            tmp[i]--;
        }
    }
}
*/
