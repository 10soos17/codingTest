package coding05_algo21_30;

//평균보다 넘은 학생들의 비율을 출력하시오
//https://www.youtube.com/watch?v=2WDfsFITi5k&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=25
public class Average24 {

	public static void main(String[] args) {
		
//		int in[] = {100, 95, 90, 80, 70, 60, 50};
//		
//		int sum = 0;
//		int cnt = 0;
//		
//		for(int i=0;i < in.length-1; i++) {
//			sum += in[i];
//		}
//		
//		double avg = (double) sum / in.length;
//		
//		System.out.println("avg: "+avg);
//
//		for(int i=0;i<in.length-1;i++) {
//			if(in[i] > avg) {
//				cnt++;
//				System.out.println(i+" 번째학생의 점수 : "+in[i]);
//				
//			}
//			
//			
//		}
//		System.out.println("평균보다 넘은 학생들의 비율: "+cnt/(double)in.length * 100);
		
		int score[] = {100, 95, 90, 80, 70, 60, 50};
		int sum = 0;
		int cnt = 0;
		
		for(int i=0;i<score.length;i++) {
			sum +=score[i];
		}
		int avg = sum/score.length;
		
		System.out.println("avg: "+avg);
		
		for(int i=0;i<score.length;i++) {
			if(score[i] > avg) {
				cnt ++;
			}
		}
		
		double ratio =Math.round((double)cnt/score.length * 100);
		
		System.out.println("비율: "+ratio+", 평균이상학생수: "+cnt);
		
	
	}
	

}
