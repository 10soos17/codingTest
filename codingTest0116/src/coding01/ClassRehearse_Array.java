package coding01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
//List계열: 자료가 순차적이고, 중복적인 자료가 있을때 사용
//ArrayList, Vector, LinkedList,,,
//Vector: Synchronized 메소드 적용, 속도 늦음,초기에 나옴
//ArrayList: 비동기화 메소드 적용, 속도가 빠름, 배열의 단점을 극복(배열 크기 가변),수정삭제에 유리

//LinkedList: List계열(자료가 순차적이고 중복적일때 사용)
//: 삽입,삭제가 많은 자료일때 유리, 인접 참조를 링크해서 체인(앞방향,역방향)처럼관리
//ArrayList: 자료에 변동성이 적을때 유리,내부배열에 객체를 저장해서 인덱스로 관리


//Queue: First In First Out, LinkedList로 구성 가능
//Stack : Last In First Out, LinkedList로 구성 가능


//Arrays, List 정리

// Object----Collection-List-ArrayList
// Object-Arrays(모든 메소드가 static)

// List는 인터페이스(객체 생성 x)-ArrayList의 부모
//ex. List<Object> arr = Arrays.asList(1,2,"aaa");
// Arrays.asList(1,"aaa")는 List<Object>()에 담기

//ArrayList<Object> res = new ArrayList<>();
//res.add(Arrays.asList("아이언맨", "헐크", "토르", "스파이더맨"));
//res.add(Arrays.asList("아이언맨1", "헐크1", "토르1", "스파이더맨1"));
//
//System.out.println(res.size());
//for (int i = 0; i < res.size(); i++) {
//
//	List l = (List)res.get(i);
//	System.out.println(l.size());
//	for(int j = 0; j< l.size();j++) {
//		System.out.println(l.get(j));
//	}
//}
public class ClassRehearse_Array {

	public static void main(String[] args) {
		// Array============================================================================
		// 생성============================================================================
		int arr11[] = new int[3];
		int[] arr22 = new int[] { 10, 20, 30 };
		int[] arr33 = { 10, 20, 30 };

		int table1[][] = new int[3][4];
		int table2[][] = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int table3[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		// 복사============================================================================
		// p.168
		// arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		// arraycopy(원래배열, 원래배열시작인덱스, 만들배열, 만들배열시작인덱스, 복사할갯수)

		char[] arr1 = { 'J', 'A', 'V', 'A' };
		// 1
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));
		// 2
		char[] arr3 = Arrays.copyOfRange(arr1, 0, arr1.length);
		System.out.println(Arrays.toString(arr3));
		// 3
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, 4);
		System.out.println(Arrays.toString(arr4));
		// 4
		// Array -> List로 복사
		String[] str = { "d", "a", "b", "c" };
		List<String> list11 = Arrays.asList(str);

		// 정렬
		Collections.sort(list11);// 재정의 불필요
		System.out.println("ar3 Sort(): " + list11);



		// List계열============================================================================

		List<String> list111 = Arrays.asList("홍길동1","홍길동2","홍길동3");
		List<String> list222 = new ArrayList(Arrays.asList("홍길동1","홍길동2","홍길동3"));
		// PolyMorphism
		List<String> list2 = null;
		list2 = new ArrayList<>();
		list2 = new LinkedList<>();
		list2 = new Vector<>();

		ArrayList<String> list = new ArrayList<>();
		list.add("포도");// 0
		list.add("딸기");// 1
		list.add(1, "키위");// 인덱스 위치에 삽입, 기존 내용 밀려나기
		list.set(0, "오렌지");// 그 위치 덮어쓰기
		list.remove(1);
		list.remove("키위");
		list.add("사과");
		list.add("앵두");
		int num = list.size();
		System.out.println(list);

		for (int i = 0; i < num; i++) {
			Object str111 = list.get(i);
			System.out.println(str111);
		}

		int index1 = list.indexOf("사과");
		int index2 = list.lastIndexOf("사과");

		System.out.println("첫번째 사과(index) : " + index1);
		System.out.println("마지막 사과(index) : " + index2);


		//Queue - LinkedList로============================================================================
		LinkedList<String> queue = new LinkedList<>();
        queue.offer("토끼");//입력
       	queue.offer("사슴");
        queue.offer("거북이");

        System.out.println(queue);
        while(!queue.isEmpty()) {
        	String str1111 = queue.poll();//출력후

        	System.out.println(str1111);
//        	String str = queue.peek();//출력후 데이터 제거X
        }

        Queue<String> q = new LinkedList<>();
        q.add("Java");
        q.add("JavaScript");
        q.add("Jsp");
        while(!q.isEmpty()) {
//        	String str = q.poll();//출력후
//        	String str = queue.peek();//출력후 데이터 제거X
        	String str3 = q.remove();//출력후 제거
        	System.out.println(str3);
        }
        //Stack - LinkedList로 ============================================================================
		LinkedList<Integer> stack = new LinkedList<>();
		stack.addLast(12);
		stack.addLast(new Integer(59));
		stack.addLast(7);
		System.out.println(stack);
        while(!stack.isEmpty()) {
        	Integer num11 = stack.removeLast();
        	System.out.println(num11);
        }
        System.out.println();

        Stack<String> s = new Stack<>();
        s.push("강남구");
        s.push("송파구");
        s.push("마포구");
        while(!s.isEmpty()) {
        	System.out.println(s.pop());//출력후 데이터 제거
        	System.out.println(s.peek());
        }



	}

}
