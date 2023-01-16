package newCoding0423;

import java.util.ArrayList;
import java.util.HashMap;

//신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.
//
//각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
//신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
//한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
//k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
//유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
//다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.
//sendMap = map:list 신고한경우, 리스트에없으면추가
//receiveMap map:int 신고한자 동일인아닌지체크, 아니면++

//for report 
//splitList =split space
//secMap = resMap[splitList[0]]
//[2,1,1,0]
public class T0_report1 {
	public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k =2;
        int[] res = solution(id_list, report, k);
	}
	
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        HashMap<String, ArrayList<String>> sendMap = new HashMap<>();
        HashMap<String, Integer> recMap = new HashMap<>();
        
        for(String s : id_list){
        	ArrayList<String> list = new ArrayList<>();
        	sendMap.put(s, list);
        }
        
        for(String s : report) {
        	String[] names = s.split(" ");
        	ArrayList<String> list = sendMap.get(names[0]);
        	
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
        answer = new int[id_list.length];
        
        ArrayList<String> res= new ArrayList<>();
        for(int i =0; i<id_list.length;i++) {
        	res.add(id_list[i]);
        }
        
        for(String s : recMap.keySet()) { 
        	if(recMap.get(s) < k) {
        		continue;
        	}
        	for(String ss : sendMap.keySet()) {
        		if(ss == s) {
        			continue;
        		}
        		if(!sendMap.get(ss).contains(s)) {
        			continue;
        		}
        		//System.out.println(res.indexOf(ss));
        		
        		answer[res.indexOf(ss)] = answer[res.indexOf(ss)]+1;
        	
        		//System.out.println(answer[res.indexOf(ss)]+",");
        			
        	}
        }
    return answer;
}
}
