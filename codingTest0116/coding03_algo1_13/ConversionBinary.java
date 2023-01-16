package coding03_algo1_13;

import java.util.ArrayList;

public class ConversionBinary {

	public static void main(String[] args) {

		int inputNum = 19;

		ArrayList<Integer> bin = new ArrayList<>();
//		
//		//1. 2로 나누고 나머지 저장 
//		while(inputNum > 0) {
//			bin.add(inputNum%2);
//			inputNum /= 2;
//			
//		}
//		//마지막 몫 저장 
//		//bin.add(inputNum);
//		
//		//거꾸로 출력 
//		for(int i=bin.size()-1;i>=0;i--) {
//			System.out.print(bin.get(i));
//		}
//		
		// 2. 라이브러리
		String bi = Integer.toBinaryString(inputNum);
		System.out.println(bi);

		// 3.recursion -  getBinary method
		bin = getBinary(inputNum, bin);

		for (int i = bin.size() - 1; i >= 0; i--) {
			System.out.print(bin.get(i));
		}
	
		

	}
	
	
	
	

	// 3.recursion
	public static ArrayList<Integer> getBinary(int num, ArrayList<Integer> bin) {

		if (num / 2 == 0) {
			//System.out.println("exit_num: " + num);
			bin.add(num);
			
			return bin;
		}

		//System.out.println("num: " + num);
		bin.add(num % 2);
		getBinary(num / 2, bin);

		return bin;
	}
	

}
