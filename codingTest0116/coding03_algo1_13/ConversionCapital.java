package coding03_algo1_13;

//대소문자 변환 -> 아스키 활용 

public class ConversionCapital {

	public static void main(String[] args) {
		
		String str = "helloWorlD";
		


		
//		//1.   .toCharArray() //ASCII
//		char [] arr;
//		
//		arr = str.toCharArray();
//		
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i] >= 'a' && arr[i] <= 'z') { //소문자면 
//				arr[i] = (char)(arr[i] + 'A' - 'a'); //동일 간격이기에, 그만큼 +
//						
//			}else if(arr[i] >='A' && arr[i] <= 'Z') { //대문자면 
//				arr[i] = (char)(arr[i] - ('A' -'a'));// 그만큼 -
//			}
//		}
//
//		System.out.println(arr);
//		
//		
//		String s = "HeLLowOrLd";
//		char [] list;
//		list = s.toCharArray();
//		for(int i=0;i<list.length;i++) {
//			if(list[i] >= 'a' && list[i] <='z') {
//				list[i] = (char)(list[i] + 'A' - 'a');
//			}else if(list[i] >= 'A' && list[i] <='Z') {
//				list[i] = (char)(list[i] - ('A' - 'a'));
//			}
//		}
		
		//2. library - .split("") // .toUpperCase() && .toLowerCase
		String [] strList = str.split("");
		
		for(int i=0;i<strList.length;i++) {
			if(strList[i].equals(strList[i].toUpperCase())) {
				strList[i] = strList[i].toLowerCase();
			}else if(strList[i].equals(strList[i].toLowerCase())) {
				strList[i] = strList[i].toUpperCase();
			}
			
		}
		for(String s: strList) {
			System.out.print(s);
		}
		
	
		
	
	}
	
	

}
