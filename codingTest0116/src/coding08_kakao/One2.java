package coding08_kakao;

import java.util.ArrayList;
import java.util.Collections;

public class One2 {

	public static void main(String[] args) {

		int[] A = new int[]{-1,-3, 5, 3}; //1

		solution(A);

	}

    public static int solution(int[] A) {
        // write your code in Java SE 8
        ArrayList<Integer> list = new ArrayList<>();
        int res=0;


        Collections.sort(list);

        //System.out.println(list.toString());
        if(list.get(list.size()-1)<0){
            res=1;
        }
        for(int i=0;i<list.size()-1;i++) {
        	int tmp = list.get(i+1) - list.get(i);
            if(list.get(i+1)<0){
                continue;
            }if(res==0 && i == list.size()-2 && tmp == 1){
                res = list.get(i+1)+1;
            }
            else{
                if(tmp>1){
                    if(list.get(i)<0) {
                        res=1;
                    }else if(list.get(i)>0){
                    res = list.get(i)+1;
                    }
                    break;
                }
            }

        }
        return res;
    }
}
        //System.out.println(res);


//    	for(int i=1;i<A.length;i++) {
//
//    		int min = A[i];
//    		int idx = i;
//
//    		while(idx > 0 && A[idx-1] > min) {
//    			int tmp = A[idx];
//    			A[idx] = A[idx-1];
//    			A[idx-1] = tmp;
//    			idx -=1;
//    		}
//    	}



