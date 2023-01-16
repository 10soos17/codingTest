package coding04_algo14_20;
//CountValue + PlusNumber 합친 문제 
//https://www.youtube.com/watch?v=-9Ne6s2dVH0&list=PLVoihNyHW4xkm_KJ8_N8X7F6EQP4uSRyR&index=15
public class CountNumbers {

	public static void main(String[] args) {
		
//		int n = 421314218;
//		
//		int arr[] = new int[10];
//		
//		while(n > 0) {
//			arr[n%10]++;
//			n /= 10;
//		}
//		
//		for(int i=0;i<arr.length;i++) {
//			
//			System.out.println(i+": " +arr[i]);
//		}
		
		int n = 421314218;
		int arr[] = new int[10];
		
		while(n>0) {
			arr[n%10]++;
			n/=10;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+":"+arr[i]);
		}
		
	
		
	
	}
	
	
	

}
