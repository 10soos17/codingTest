package codingTest_pro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class hash_songList {

	public static void main(String[] args) {
		//["classic", "pop", "classic", "classic", "pop"]
		//[500, 600, 150, 800, 2500]
		//[4, 1, 3, 0]
		String [] arr1 = {"classic", "pop", "classic", "classic", "pop"};
		int [] arr2 = {500, 600, 150, 800, 2500};

		solution(arr1, arr2);

	}

	public static ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> nPlayer = new ArrayList<>();

        for (int play : plays) {
        	nPlayer.add(play);
        }

        for(int i=0;i<genres.length;i++) {
        	int n=0;
        	if(map.containsKey(genres[i])) {
        		n=map.get(genres[i]);
        		n+=plays[i];
        	}else {
        		n=plays[i];
        	}
        	map.put(genres[i], n);
        }

        List<String> list = new ArrayList<>(map.keySet());


//        System.out.println(list.size());
//        for(String s:list) {
//        	System.out.println(s);
//        }


        for(String s:list) {
        	ArrayList<Integer> tmp = new ArrayList<>();
        	for(int i=0;i<genres.length;i++) {
        		if(s.equals(genres[i])) {
        			tmp.add(plays[i]);
        			//System.out.println("skf"+plays[i]);
        		}
        	}
        	Collections.sort(tmp, (a,b)->b.compareTo(a));


        	for(int j=0;j<2;j++) {
        		System.out.println(tmp.get(j));
        		int idx = nPlayer.indexOf(tmp.get(j));
        		answer.add(idx);

        	}
        }
//        for(int i=0;i<answer.size();i++) {
//        	System.out.println(answer.get(i));
//        }




        return answer;
    }
}