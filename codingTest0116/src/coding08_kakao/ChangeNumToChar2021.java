package coding08_kakao;

import java.util.HashMap;

public class ChangeNumToChar2021 {

	public static HashMap<String, Integer> map;

	public static void main(String[] args) {

		map = new HashMap<>();

		map.put("zero",0);
		map.put("one",1);
		map.put("two",2);
		map.put("three",3);
		map.put("four",4);
		map.put("five",5);
		map.put("six",6);
		map.put("seven",7);
		map.put("eight",9);
		map.put("nine",9);
		String s = "one4seveneight";
		solution(s);

	}
    public static int solution(String s) {

        for(String str : map.keySet()) {
        	map.get(str);
        	s=s.replaceAll(str, String.valueOf(map.get(str)));

        }
        System.out.println(s);
        return Integer.parseInt(s);
    }

}
