package newCoding0628_level1;

class T22_findPY {
//	대문자와 소문자가 섞여있는 문자열 s가 주어집니다. 
//	s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 
//	s	answer
//	"pPoooyY"	true
//	"Pyy"	false	
	public static void main(String[] args) {

		String n = "pPoooY";

		boolean res = solution(n);

		System.out.println(res);

	}

	public static boolean solution(String s) {
//    	s = s.toLowerCase();
//    	s = s.replaceAll("[^py]", "");

    	int sum=0;
    	for(int i=0;i<s.length();i++) {
    		String lower = (s.charAt(i)+"").toLowerCase();
    		if(lower.equals("p")) {
    			sum++;
    		}else if(lower.equals("y")) {
    			sum--;
    		}	
    	}
    	if(sum !=0 ) return false;;

    	return true;
	}

}