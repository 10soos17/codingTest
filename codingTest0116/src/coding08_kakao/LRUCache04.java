package coding08_kakao;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=4PLmnddPDaQ&list=PL2lVRutSfJd-aUSEkdMO8QbRuL5tPOrie&index=5
public class LRUCache04 {

	public static void main(String[] args) {

		LRUCache(3, new String[] {});


	}

	public static void LRUCache(int cacheSize, String[] cities) {

		int runningTime = 0;
		Map<String, Integer> map = new HashMap<>();

		for (String target : cities) {
			if(map.containsKey(target.toUpperCase())) {
				runningTime++;
			}else {

				runningTime +=5;

				if(cacheSize > map.size()) {
					map.put(target.toUpperCase(), map.size()+1);
				}else {
					String delKey = "";

					for(String key : map.keySet()) {
						if(map.get(key) == 1) {
							delKey = key;
						}else {
							map.put(key,map.get(key)-1);
						}

						map.remove(delKey);
						map.put(target.toUpperCase(), map.size()+1);
					}
				}
			}

			System.out.println(runningTime);
		}

	}

}
