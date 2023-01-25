package newCoding0821_HS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

//https://www.acmicpc.net/problem/20006
//	10 5
//	10 a
//	15 b
//	20 c
//	25 d
//	30 e
//	17 f
//	18 g
//	26 h
//	24 i
//	28 j

public class T_BJ_matchingPlayer {

	public static void main(String[] args) throws Exception {

		ArrayList<String> list = new ArrayList<>();
		TreeMap<String, Integer> inMap = new TreeMap<>();
		Map<String, TreeMap<String, Integer>> map = new TreeMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		int PLAYER = Integer.parseInt(st.nextToken());
		int LIMIT = Integer.parseInt(st.nextToken());

		for (int i = 0; i < PLAYER; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			boolean flag = false;

			if(i==0) {
				inMap.put(name, level);
				String room = level + " " + name;
				list.add(room);
				map.put(room, inMap);
				continue;
			}

			for (String roomKey : list) {
				inMap = map.get(roomKey);

				int rLevel = Integer.parseInt(roomKey.split(" ")[0]);

				if(Math.abs(rLevel-level) <= 10 && map.get(roomKey).size() < LIMIT) {
					inMap = map.get(roomKey);
					inMap.put(name, level);
					map.put(roomKey, inMap);
					flag = true;
					break;
				}
			}

			if(!flag) {
				inMap = new TreeMap<>();
				inMap.put(name, level);
				String room = level + " " + name;
				list.add(room);
				map.put(room, inMap);
			}
		}

		for(int i=0;i<list.size();i++) {
			inMap = map.get(list.get(i));
			if(i!=0) System.out.println();
			if(inMap.size() < LIMIT) System.out.print("Waiting!");
			else System.out.print("Started!");

			for(String n :inMap.keySet()) {
				System.out.println();
				System.out.print(inMap.get(n) + " "+ n);
			}
		}
	}
}
