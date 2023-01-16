package coding08_kakao;


import java.util.HashMap;

public class PushKeyPad2020 {
	//static String key[][]= new String[][] {};
	static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) {
		

		/*
		 * [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
			[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
			[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	 "right"	"LLRLLRLLRL"
		 */
//		key = new String[][]{
//							{"1","2","3"},
//							{"4","5","6"},
//							{"7","8","9"},
//							{"*","0","#"}
//						};
//		
		int arr[] = new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		
		
		map.put("1","00");
		map.put("2","01");
		map.put("3","02");
		map.put("4","10");
		map.put("5","11");
		map.put("6","12");
		map.put("7","20");
		map.put("8","21");
		map.put("9","22");
		map.put("*","30");
		map.put("0","31");
		map.put("#","32");
		
		solution(arr, "right");
		
	}
	
    public static String solution(int[] numbers, String hand) {
    	if(hand.equals("right")) {
    		hand = "R";
    	}else {
    		hand="L";
    	}
    	System.out.println(hand);
        String answer = "";
        String leftP= map.get("*");
        String rightP = map.get("#");
        
        
        for(int i=0; i<numbers.length;i++) {
        	
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        		answer+="L";
        		leftP=map.get(String.valueOf(numbers[i]));
        		System.out.println(i+":"+numbers[i]+"->"+"L");
        	}
        	else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        		answer+="R";
        		rightP=map.get(String.valueOf(numbers[i]));
        		System.out.println(i+":"+numbers[i]+"->"+"R");
        	}
        	else {
        		String lList[] = leftP.split("");
        		String rList[] = rightP.split("");
        		String valList[] = map.get(String.valueOf(numbers[i])).split("");
        		System.out.println(valList[0]+valList[1]);
        		
        		int lDistance = Math.abs(Integer.parseInt(valList[0])-Integer.parseInt(lList[0])) + 
        						Math.abs(Integer.parseInt(valList[1])-Integer.parseInt(lList[1]));
        		int rDistance = Math.abs(Integer.parseInt(valList[0])-Integer.parseInt(rList[0])) + 
								Math.abs(Integer.parseInt(valList[1])-Integer.parseInt(rList[1]));
        		System.out.println("lDistance:"+lDistance+",rDistance:"+rDistance);
        		if(lDistance > rDistance) {
        			answer+="R";
            		rightP=map.get(String.valueOf(numbers[i]));
            		System.out.println(i+":"+numbers[i]+"->"+"R(cal)");
        		}else if(lDistance < rDistance) {
        			answer+="L";
            		leftP=map.get(String.valueOf(numbers[i]));
            		System.out.println(i+":"+numbers[i]+"->"+"L(cal)");
        		}else {
        			answer+=hand;
        			System.out.println(i+":"+numbers[i]+"->"+"HAND(cal)");
        			if(hand.equals("R")) {
        				rightP=map.get(String.valueOf(numbers[i]));
        			}else {
        				leftP=map.get(String.valueOf(numbers[i]));
        			}
        		}
        	}
        }
        
        
        System.out.println(answer);
        return answer;
    }

}
