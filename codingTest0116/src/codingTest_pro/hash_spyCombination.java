package codingTest_pro;

import java.util.ArrayList;
import java.util.HashMap;

public class hash_spyCombination {

	public static void main(String[] args) {
		//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]] ->	[5, 6, 3]
		String [][] arr1 = {
				{"yellowhat", "headgear"},
				{"bluesunglasses", "eyewear"},
				{"green_turban", "headgear"}
				};//false

		solution(arr1);

	}

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (String[] element : clothes) {
        	if(map.containsKey(element[1])) {

        		list = map.get(element[1]);
        		list.add(element[0]);
        		map.put(element[1], list);
        	}else {

        		list = new ArrayList<>();
        		list.add(element[0]);

        		map.put(element[1], list);


        	}
        	//System.out.println(clothes[i][0]);

        }

//        Iterator<Entry<String, ArrayList<String>>> entries = map.entrySet().iterator();
//        while(entries.hasNext()) {
//        	HashMap.Entry<String, ArrayList<String>> entry = entries.next();
//        	System.out.println(entry.getKey()+":"+entry.getValue());
//        }

        for(String s:map.keySet()) {
        	answer *= map.get(s).size()+1;
        	//System.out.println(map.get(s));
        }

        //System.out.println(answer);
        return answer-1;
    }
}