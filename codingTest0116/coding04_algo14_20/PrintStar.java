package coding04_algo14_20;



public class PrintStar {

	public static void main(String[] args) {
		//*
		//**
		//***
		//****
		//*****
		int n = 5;

//		for(int i=0;i<n;i++) {
//			for(int j=0;j<i+1;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		

		//*****
		//****
		//***
		//**
		//*
		
	
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n-i;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
	for(int i=0;i<n;i++) {
		for(int j=0;j<n-i;j++) {
			
			System.out.print("*");
		}
		System.out.println();
	}
	
	
	
	
		//*****
		// ****
		//  ***
		//   **
		//    *
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				if(i > j) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");	
//				}
//				
//			}
//			System.out.println();
//		}
	
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			if(j>=i) {
			System.out.print("*");
			}else {
				System.out.println(" ");
			}
		}
		System.out.println();
	}
		
		
		//    *
		//   **
		//  ***
		// ****
		//*****
		
//		//1
//		for(int i=0; i<n; i++) {
//			for(int j=n-1; j>=0; j--) {
//				if(i < j) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");	
//				}
//				
//			}
//			System.out.println();
//		}
//		
//		//2
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(i < n-(j+1)) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");	
//				}
//				
//			}
//			System.out.println();
//		}

		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j >=n-i-1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(n-(j+1) <= i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=n-1;j>=0;j--) {
				if(j<=i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
		

	}

}
