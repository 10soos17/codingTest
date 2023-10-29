package coding03_algo1_13;

//각 자릿수의 합
//https://www.youtube.com/watch?v=NldRYbDqgKw&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=11
public class PlusNumber {

	public static void main(String[] args) {
//		int num = 1232;
//
//		int sum = 0;
//
//		while(num > 0) {
//			sum += num % 10; //10으로 나눈 나머지 더하기
//			num /=10; //10으로 나눈 몫으로 값 갱신
//		}
//		System.out.println(sum);

		int num = 1242;
		int sum=0;

		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		System.out.println(sum);



	}

}
