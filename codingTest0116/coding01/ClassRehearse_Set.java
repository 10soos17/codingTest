package coding01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

//Set : 2가지 의미(1.저장, 2. 집합)중 여기서는 집합(주머니)개념이다
//: 주머니속의 데이터이므로, 데이터의 순서, 중복이 없음
//HashSet(가장많이 사용), TreeSet(검색용)
//Search : TreeSet:Tree구조에 저장, 자동으로 정렬,부모값과 비고해서 작으면 왼쪽, 크면 오른쪽에 저장
public class ClassRehearse_Set {

	public static void main(String[] args) {
		//Set============================================================================
		HashSet<String> hs = new HashSet<String>();
		hs.add("Java");
		hs.add("JavaScript");
		hs.add("jQuery");
		hs.add("AJax");
		hs.add("AJax");
		
		System.out.println("주머니의 크기: "+hs.size());
		System.out.println(hs);
		
		//advanced for
		for(String s : hs)
			System.out.print(s+" ");
		System.out.println();
		
		//iterator()
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			String element = it.next();
			System.out.print("\t"+element);
		}
		//TreeSet============================================================================
		TreeSet<Integer> t = new TreeSet<>();
		int[] score= {80,95,50,35,45,65,10,100};
		
		Integer it1 = null;
		//방법1
		t.add(new Integer(80));
		
       //방법2
		for(int i=0; i<score.length; i++)
			t.add(new Integer(score[i]));
		
		System.out.println(t);//자동 오름차순
		System.out.println("가장 낮은 점수: "+t.first());//last
		System.out.println("65 아래 점수: "+t.lower(65));//higher
		System.out.println("65이거나 바로 아래 점수: "+t.floor(64));//ceiling
//		while(!t.isEmpty()) {
//			it = t.pollFirst();//pollLast()
//			System.out.println(it+"(남은 객체수: "+ t.size()+")");
//		}
		//내림차순 정렬
		//NavigableSet<E>	descendingSet()
		NavigableSet<Integer> ns = 	t.descendingSet();
		for(Integer s : ns)
			System.out.print(s+" ");
		
		System.out.println();
		
		TreeSet<String> ts = new TreeSet<>();
		ts.add("apple");
		ts.add("forever");
		ts.add("description");
	
		System.out.println(ts);
		//c<= 값 <= f
		NavigableSet<String> ns11 = 	ts.subSet("c", true, "f", true);
		for(String s : ns11)
			System.out.print(s+" ");
	
		
	}

}
