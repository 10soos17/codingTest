package coding04_algo14_20;

//369게임
//369가 포함된 개수만큼 짝 출력
//https://www.youtube.com/watch?v=rXNm4YpPVNc&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=21
public class Game369 {

	//해당 수에 3,6,9가 몇 번 나오는 지 카운트하는 메소드
	public static int getNum(int i) {
		int j = 0;

		while(i > 0) {

			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9)
				j++;
			i /=10;

		}

		return j;
	}

	public static void main(String[] args) {
//		int n = 100;
//
//		//범위 숫자까지 포문 돌면서 카운트 메소드 호출
//		for(int i=1; i<=n; i++) {
//			int cnt = getNum(i);
//
//			if(cnt == 0) { //카운트가 0이면 숫자 출력
//				System.out.print(i+" ");
//			}else {//카운트만큼 짝 출력
//				for(int l =0; l < cnt;l++) {
//				System.out.print("짝");
//				}
//				System.out.print(" ");
//			}
//		}

		int n=100;

		for(int i=0;i<=n;i++) {
			int cnt = getNum(i);

			if(cnt ==0) {
				System.out.print(i+ " ");
			}
			else {
				for(int j=0;j<cnt;j++) {
					System.out.print("짝");
				}
			System.out.println(" ");
			}
		}




	}



}
