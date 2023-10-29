package coding01;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

//HashTable: Map계열,Synchronized 메소드로 구성
//비동기화 메소드: HashMap
public class ClassRehearse_Map {

	public static void main(String[] args) {
		//Map============================================================================
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(new String("홍길동"),new Integer(90) );
		hm.put(new String("홍길동"),new Integer(90) );
		hm.put(new String("홍길동3"),new Integer(80) );
		hm.put(new String("홍길동4"),new Integer(60) );

		System.out.println(hm);
		//entrySet(), iterator()
		Set<Map.Entry<String, Integer>> set = hm.entrySet();
		Iterator<Entry<String, Integer>> it =  set.iterator();
        while(it.hasNext()) {
        	Entry<String, Integer> e = it.next();
        	System.out.println("이름: "+e.getKey()+", 점수: "+e.getValue());
        }

        //keySet(), iterator()
        Set<String> keySet =  hm.keySet();
        Iterator<String> it2 =  keySet.iterator();
        while(it2.hasNext()) {
          String key = 	it2.next();
          Integer value = hm.get(key);
          System.out.println("이름: "+key+", 점수: "+value);
        }

        //HashTable============================================================================
		Map<String, String> ht2 = new Hashtable<>();
		ht2.put("name", "홍길동");
		ht2.put("age", "20");
		ht2.put("address", "서울");

		System.out.println(ht2);

		//방법1: keySet(), iterator()
		Set<String> keySet1 = ht2.keySet();
		Iterator<String> it22 = keySet1.iterator();
		while (it2.hasNext()) {
			String key = it22.next();
			String value = ht2.get(key);
			System.out.println("키1: " + key + ", 값: " + value);
		}


		//방법2:  Enumeration<K> keys()
		Enumeration<String> e =  ((Hashtable<String, String>) ht2).keys();
		while(e.hasMoreElements()) {
		   String k =	e.nextElement();
		   String v = ht2.get(k);
		   System.out.println("키2: " + k + ", 값: " + v);
		}


		//방법3
		Vector<String> v = new Vector<>(ht2.keySet());

		for (String key : v) {
			 String value = ht2.get(key);
		   System.out.println("키3: " + key + ", 값: " + value);

		}
		//TreeMap->자동으로 정렬============================================================================
		TreeMap<Integer,String> tm = new TreeMap<>();
		tm.put(new Integer(87), new String("홍길동1"));
		tm.put(new Integer(98), new String("홍길동2"));
		tm.put(new Integer(75), new String("홍길동3"));
		tm.put(new Integer(95), new String("홍길동4"));
		tm.put(new Integer(80), new String("홍길동5"));

		System.out.println(tm);//자동 정렬: 오름차순

		//내림차순
        //NavigableMap<K,V>	descendingMap() :내림차순으로 정렬된 Map.Entry의  NavigableMap리턴
		NavigableMap<Integer,String> nm = tm.descendingMap();
		Set<Map.Entry<Integer, String>> des = nm.entrySet();
		for(Map.Entry<Integer, String> entry :  des)
			System.out.println(entry.getKey()+" : "+ entry.getValue());

		//오름차순
		NavigableMap<Integer,String> am = nm.descendingMap();
		Set<Map.Entry<Integer, String>> aes = am.entrySet();
		for(Map.Entry<Integer, String> entry :  aes)
			System.out.println(entry.getKey()+" : "+ entry.getValue());



	}

}
