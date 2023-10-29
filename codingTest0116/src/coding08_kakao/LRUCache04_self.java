package coding08_kakao;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=4PLmnddPDaQ&list=PL2lVRutSfJd-aUSEkdMO8QbRuL5tPOrie&index=5
public class LRUCache04_self {

	public static void main(String[] args) {

		LRUCache(3, new String[] {});
		LRUCache(3, new String[] {});
		LRUCache(2, new String[] {});
		LRUCache(0, new String[] {});

	}

	public static void LRUCache(int cacheSize, String[] cities) {

		int runningTime = 0;
		Map<String, Integer> map = new HashMap<>();

		for (String target : cities) {
			//1.cache에 도시가 있는 지 찾기
			if(map.containsKey(target.toUpperCase())) {
				//1.1 값이 있으면 cache hit 1(시간+1)
				runningTime ++;


				//추가 알고리즘


			}else {
				//1.2 값이 없으면 cache hit 2(시간+5)
				runningTime += 5;

				//1.2.1 cacheSize 보다 입력된 도시가 적으면 put
				if(cacheSize > map.size()) {//저장크기 초과하지 않았을 경우(= 초기 캐쉬크기만큼 저장)
					map.put(target.toUpperCase(), map.size()+1);
				}else {//저장크기 초과 시, 첫번째 캐쉬값 삭제 후 && 나머지 저장된 캐쉬값 각 순번 -1 해주기  && 새로 들어오는 값 넣기
					//1.2.2 cacheSize 보다 입력된 도시가 같거나 많으면 remove & put
					String delKey = "";
					for(String key : map.keySet()) {
						if(map.get(key) == 1) {
							//1.2.2.1 제거
							delKey = key;
						}else {
							//1.2.2.2 각 순위 -1
							map.put(key, map.get(key)-1);
						}
						//1.2.2.3 remove & put
						map.remove(delKey);
						map.put(target.toUpperCase(), map.size()+1);

					}
				}
			}

			System.out.println("Running Time ::"+runningTime);
		}
	}

}
