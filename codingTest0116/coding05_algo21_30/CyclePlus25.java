package coding05_algo21_30;

//https://www.youtube.com/watch?v=fP1UTjZ_Yrw&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=26
public class CyclePlus25 {

	public static void main(String[] args) {
		
		int n = 26;
		int res = n;
		int tmp = 0;
		
		int cnt = 0;
		
		//26 2+6=8 => 68 6+8=14 => 84 8+4=12 =>42 4+2=6 => 26 4회
		//05 0+5=5 => 55 5+5=10 => 50 5+0=5 => 05 => 3회
		//42 4+2=6 => 26 2+6=8 => 68 6+8=14 => 84 8+4=12 => 42 4회
		
		
		do{
			
			tmp = res / 10 + res % 10;//몫+나머지 
			res = res%10*10 + tmp % 10;//새수의 일의자리  = 방금 계산한 수의 일의 자리 & 새수의 10의자리 = 그 전 수의 1의 자리 
			cnt++; // 횟수 ++
			
		}while(n != res); //원래 수와 같아질 때까지
		
		
		System.out.println(cnt);
	}

}
