package coding08_kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//https://cwondev.tistory.com/15

public class FailRate2019 {

	public static void main(String[] args) {
		/*
		 * 5 [2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
		   4 [4,4,4,4,4]	[4,1,2,3]
		 */
		int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		solution(5,stages);

	}

	//스테이지와 & 실패율 같이 저장하는 클래스
	public static class Fail{
		int stage;
		double rate;

		Fail(int stage, double rate){
			this.stage = stage;
			this.rate = rate;
		}

	}

	static Comparator<Fail> comp = new Comparator<>() {
		@Override
		public int compare(Fail a, Fail b) {
			if(a.rate < b.rate)
				return 1;//뒤
			else if(a.rate > b.rate)
				return -1;//앞
			else {//실패율 같을 때
				if(a.stage > b.stage)//스테이지 번호 큰 게 뒤로
					return 1;
				else if(a.stage < b.stage)
					return -1;
				else
					return 0;
			}
		}

	};


	//N : 스테이지 개수 //stages배열 : 유저가 머물러있는 스테이지
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        List<Fail> fails = new ArrayList<>();//실패율 저장할 리스트

        // 스테이지 차례로 루프 돌때,
        //해당 스테이지에 머물러 있는 유저수만큼 토탈에서 빼주고 그 다음 스테이지 실패율 계산 계산
        int total = stages.length;//유저수 == 실패율 분자

        int[] users = new int[N+1];//스테이지에 도달한 유저 수 저장 배열 == 실패율 분모


        //스테이지에 있는 유저수 증가
        for(int s : stages) {
        	users[s-1]++;//1번스테이지 0번에 저장
        }

        //for문 각 스테이지의 user 수
        for(int i=0; i<N; i++) {
        	if(users[i] == 0) {//현 스테이지 머무는 사람 수 = 0 이면, 실패율이 0임
        		fails.add(new Fail(i+1, 0));//실제 스테이지는 1부터이기에 +1, 실패율 = 0
        	}else {//현 스테이지 머무는 사람 수 != 0 이면, 실패율 계산 -> 현 스테이지 유저수 / 스테이지에 도단한 유저수
        		fails.add(new Fail(i+1, (double)users[i]/total));//실패율 = 현 스테이지 유저수 / 스테이지에 도단한 유저수
        		total -= users[i];//실패했으면 그 다음 스테이지못갔기에 -해줌
        	}
        }


        //sort
        Collections.sort(fails, comp);

        //실패율 따라 stage 저장
        for(int i=0;i<N;i++) {
        	answer[i] = fails.get(i).stage;
        	System.out.println(answer[i]);
        }


        return answer;
    }

}
