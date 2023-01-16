package coding08_kakao;

public class seauenceNumberCount06 {

	public static void main(String[] args) {
		
		String result = "";
		int times = 10;
		//10번 반복
		
		for(int seq = 0;seq<times;seq++) {
			//시작은 1
			if("".equals(result)) {
				result = "1";
			}else {
				char[] input = result.toCharArray();
				result="";
				String target = "";
				
				for(int i=0;i<input.length;i++) {
					
					if(i == 0) {//첫문자는 target에 append 
						target = ""+input[i];
						result="1";
					}					
					else if(target.charAt(0) == input[i]) {//똑같은 문자는 target에 append 
						
						target += "" + input[i];
					}
					else {//다른 문자 result에 target 수를 append, 첫문자는 target에 append 
						result += "" + target.length() + input[i];
						target = "" + input[i];
					}
					if(i == (input.length-1)) {
						result += "" + target.length();
					}
			
				}
			}
			//출력 
			
			System.out.printf("%2d 회전 - %s\n", (seq+1), result);
		}

	}

}
