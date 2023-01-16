package coding05_algo21_30;

public class ConversionBinary28 {

	public static void main(String[] args) {
		//input 19 16 output 13
		
		char n[] = new char[100];
		
		//A, B, C ... F
		
		int num =11111;
		int jinsu = 16;
		int k = 0;

		
		while(num > 0) {
			int temp = num % jinsu;
			
			if(temp >= 10 && temp <= 15) {
				n[k] = (char)('A' + (temp - 10));
			}else {
				n[k] = (char)('0'+temp);
			}
			num/=jinsu;
			k++;
		
		}

		for(int i=k;i>=0;i--) {
			System.out.print(n[i]);
		}
		
		System.out.println();
		
		
		
		
	
		
		
	}

}
