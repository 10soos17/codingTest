package newCoding0523;

//대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
//다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
//단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//s	answer
//"pPoooyY"	true
//"Pyy"	false

public class T9_countPY {
	public static void main(String[] args) {
		String s = "pPoooyY";
		boolean answer = solution(s);
		System.out.println(answer);

	}

	public static boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;

        for(int i=0;i<s.length();i++) {
        	String ss = ""+s.charAt(i);
        	if(ss.equals("p") || ss.equals("P")) {
        		cnt++;
        	}
        	else if(ss.equals("y") || ss.equals("Y")) {
        		cnt--;
        	}
        }
        if(cnt!=0) return false;

        return answer;
    }

}