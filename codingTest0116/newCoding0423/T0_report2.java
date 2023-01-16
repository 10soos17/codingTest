package newCoding0423;

import java.util.ArrayList;
import java.util.HashMap;

//sendMap = map:list 신고한경우, 리스트에없으면추가
//receiveMap map:int 신고한자 동일인아닌지체크, 아니면++

//for report 
//splitList =split space
//secMap = resMap[splitList[0]]
//[2,1,1,0]
public class T0_report2 {
	public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k =2;
        int[] res = solution(id_list, report, k);
        for(int i : res) {
        	System.out.print(i+" ");
        }
        
        
	}
	
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        
        HashMap<String, ArrayList<String>> sendMap = new HashMap<>();
        HashMap<String, Integer> recMap = new HashMap<>();

        for(String s : report) {
        	String[] names = s.split(" ");
        	ArrayList<String> list = new ArrayList<>();

        	
        	if(!sendMap.containsKey(names[0])) {
        		list.add(names[1]);
        		sendMap.put(names[0],list);
        		
            	if(recMap.containsKey(names[1])) {
            		recMap.put(names[1], recMap.get(names[1])+1);
            	}else {
            		recMap.put(names[1], 1);
            	}
        		continue;
        	}
        	
        	list = sendMap.get(names[0]);
        	if(list.contains(names[1])) {
        		continue;
        	}
        	list.add(names[1]);
        	sendMap.put(names[0], list);
        	
        	if(recMap.containsKey(names[1])) {
        		recMap.put(names[1], recMap.get(names[1])+1);
        	}else {
        		recMap.put(names[1], 1);
        	}
        	
        }
        
        //
        for(int i = 0; i < id_list.length;i++) {
        	if(!sendMap.containsKey(id_list[i])) {
        		answer[i] = 0;
        		continue;
        	}
        	
        	ArrayList<String> sList = sendMap.get(id_list[i]);
        	for(String s : sList) {
        		if(recMap.get(s)<k) {
        			continue;
        		}
        		answer[i]++;
        	}
        }

    return answer;
}
}
