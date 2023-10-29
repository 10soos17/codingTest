package coding01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

////정렬
//https://blog.naver.com/tnrusl1020/222328220974
//
//
////List 경우
//List<String> list1 = new ArrayList<>();
//List<Integer> list2 = new ArrayList<>();
//Collections.sort(배열이름);
//Collections.reverse(배열이름);
//
////Comparable -> compareTo() 메소드 vs Comparator -> compate( , ) 메소드
//ex.comparator
//호출
//Collections.sort(fails, comp); ->객체 요소일 경우에, compare 메소드 재정의 하기
//Collections.sort(list);
//
//
//재정의
//기본적으로 양수일경우, 위치를 바꾸고,
//0 이나 음의 정수인 경우는, 두 객체의 위치는 바뀌지 않는다. 
//compare(int o1,int o2)
//=> return -1 (o1 < o2)o1이 더 작은경우, 음수리턴하게함 자리안바꿈 -> 따라서 결과 오름차순
//     return 1 (o1 < o2) 내림차순 o1이 더 큰 경우, 양수 리턴하게함 ->자리바꿈 ->따라서 결과 내림차순
//
//
//	static Comparator<Fail> comp = new Comparator<Fail>() {
//		public int compare(Fail a, Fail b) {
//			if(a.rate < b.rate)
//				return 1;//뒤
//			else if(a.rate > b.rate)
//				return -1;//앞
//			else {//실패율 같을 때
//				if(a.stage > b.stage)//스테이지 번호 큰 게 뒤로
//					return 1;
//				else if(a.stage < b.stage)
//					return -1;
//				else
//					return 0;
//			}
//		}
//
//	};
//
//ex.
//List<Animal> ak = new ArrayList<Animal>();
//Collections.sort(ak,(a,b)) -> a.age - b.age); //오름차순 정렬
//collections.sort(ak,(a,b)) -> b.age - a.age); //내림차순 정렬
//
//ex. 단어 정렬
//String[] arr = new String[N];	// 배열에 단어가 이미 초기화 되었다고 가정
//
//Arrays.sort(arr, new Comparator<String>() {
//	@Override
//	public int compare(String s1, String s2) {
//		// 단어 길이가 같을 경우
//		if(s1.length() == s2.length()} {
//			return s1.compareTo(s2);	// 사전 순 정렬
//		}
//		// 그 외의 경우
//		else {
//			return s1.length() - s2.length();
//		}
//	}
//});


public class SortEx {

	public static class Person{
		public String name;
		public Integer age;

		public Person() {
			// TODO Auto-generated constructor stub

		}

		public Person(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}


	}

	static Comparator<Person> comp = new Comparator<>() {

		@Override
		public int compare(Person a, Person b) {
			if(a.age < b.age)
				return -1;//뒤
			else if(a.age > b.age)
				return 1;//앞
			else {
					return 0;
			}
		}

	};

	public static void main(String[] args) {


		List<String> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		list1.add("bcd");
		list1.add("acd");
		list1.add("ccd");

		list2.add(3);
		list2.add(432);
		list2.add(-1);

		Collections.sort(list1);
		System.out.println(list1);
		Collections.reverse(list1);
		System.out.println(list1);


		Collections.sort(list2);
		System.out.println(list2);
		Collections.reverse(list2);
		System.out.println(list2);


        List<Person> list3 = new ArrayList<>();//실패율 저장할 리스트
		list3.add(new Person("bbb", 9));
		list3.add(new Person("ccc", 3));
		list3.add(new Person("aaa", 5));

		Collections.sort(list3, comp);

        //sort
		for(Person pp:list3) {
			System.out.println(pp.age);


		}
	}



}

