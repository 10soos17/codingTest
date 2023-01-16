package coding01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import coding02_package.Character;
import coding02_package.Person;
import coding02_package.Hero;
import coding02_package.ICharacter;
import coding02_package.Magician;

public class basicPractice {

	public static void main(String[] args) {
//		// 기본타입 
//		int i = 1;
//		long l = 10L;
//		short s = 10;
//		byte b = 10;
//		
//		double d = 10.0;
//		float f = 10.0f;
//		
//		boolean bool = true;
//		bool = false;
//		
//		char c = '씨';
//		
//		String str = "여러글자";
//		
//		//형변환 
//		i = (int) 10L;
//		
//		//문자열 출력 
//		System.out.println("test"+ i);
//		
//		System.out.printf("내이름%s, 나이%d, 키%f\n","홍길동", 20, 180.3f);
//		
//		//math
//		System.out.println(Math.max(10,30));
//		System.out.println(Math.min(10,30));
//		System.out.println(Math.abs(-10));
//	
//		//문자열 <-> 숫자 변환 
//		String str1 = "100";
//		
//		int ii = Integer.parseInt(str1);
//		
//		String str2 = String.valueOf(ii);
//		
//		System.out.println(ii);
//		
//		//random
//		Random random = new Random();
//		int rand = random.nextInt();
//		//0~9
//		int randd = random.nextInt(10);
//		//5~9
//		int randdd = random.nextInt(4)+5;
//		
//		System.out.println(rand);
//		System.out.println(randd);
//		System.out.println(randdd);
//		
//		//scanner
//		Scanner scanner = new Scanner(System.in);
//		
//		/*String str3 = scanner.next();
//		int iii = scanner.nextInt();
//		long ll = scanner.nextLong();
//		*/
//		
//		//조건 if
//		
//		int iiii = 10;
//		
//		if(iiii < 11) {
//			System.out.println("참");
//		}else if(i >11){
//			System.out.println("거짓");
//			
//		}else {
//			System.out.println("나머지");
//			
//		}
//		
//		//조건 
//		boolean isMarried = true;
//		String str4;
//		
//		str4 = isMarried ? "yes" : "no";
//		System.out.println(str4);
//		
//				
//		//switch 
//		switch (str4) {
//			case "yes":
//				System.out.println("o");
//				break;
//			case "no":
//				System.out.println("x");
//				break;
//			default:
//				System.out.println("?");
//		}
//		System.out.println(str4);
//		
//		//for
//		for(int j = 0; j < 10; j++) {
//			if(j == 6) {
//				continue;
//			}
//			System.out.println(j);
//		}
//		
//		//while & do while
//		
//		int k=0;
//		while(k<10) {
//			System.out.println(k);
//			k++;
//		}
//		do {
//			System.out.println(k);
//			k--;
//		}while(k>0);
		
		
		
		//int 배열
		int[] score = new int[5];
		score = new int[] {10,20,30,40,50};
		
		int count = score.length;
		score[0] = 10;
		
		System.out.println(score[0]);
		System.out.println(score[score.length -1]);
		
		//String 배열 -> 초기값 설정하지 않으면 null
		String[] names = new String[2];
		
		System.out.println(names[0]);
		
		//list
		ArrayList<Integer> scoreList = new ArrayList<>();
		scoreList.add(10);
	
		scoreList.add(1,200);
		System.out.println(scoreList);
		System.out.println(scoreList.get(1));

		scoreList.remove(1);
		
		System.out.println(scoreList.get(0));
		
		
		//method
		add(40,10);
		
		//overload
		getAdd(1,2);
		getAdd(1,2,3);
		getAdd(1,2,3,4,5,6,7,8);
		
		
		//다른 package 
		Person person = new Person();
		Person person2 = new Person("신수", 10);

		System.out.println(person);
		System.out.println(person2);
		
		//다른 package  + Override
		//Person -> (상속)(interface-attack메소드 강제생성하게끔)ICharacter -> (상속) Magician 
		//Person -> (상속)(abstract클래스-attack메소드 강제생성하게끔)Character -> (상속) Hero
		
		//=>공통점:상속시 둘다 메소드 강제 생성해야함 
		//=>차이점: interface만 다중상속 가능 
		
		Hero hero = new Hero("슈퍼맨");
		Hero hero2 = new Hero("배트맨");
		hero.attack(hero2);
		
		//다형성 - 객체 생성법 
		Character character = new Hero("슈퍼맨2");
		Magician magicain = new Magician();
		Character magician2 = new Magician();
		
		ICharacter magician3 = new Magician();
		
		//instanceof
		if(magician2 instanceof Magician) {
			System.out.println("instanceof ok");
			
		}
		
		ArrayList<Character> characterArrayList = new ArrayList<>();
		characterArrayList.add(magicain);
		characterArrayList.add(magician2);
		characterArrayList.add(hero);
		
		//Generic -여러가지 타입을 넘겨서 사용 
		print("안녕");
		print(1);
		print(3L);
		print(true);
		
		//Thread
		System.out.println("Th1");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i=0;i<5;i++) {
					try {
						Thread.sleep(1000);
						System.out.println("Th3"+Thread.currentThread().getName()+":"+i);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		
		//Ramda 표현
		//Runnable 은 interface & 추상메소드가 run(){} 1개이기에 
		//run(){} 메소드를 "()->" 로 표시 가능 
		new Thread(() -> {
			
				for(int i=5;i<10;i++) {
					try {
						Thread.sleep(1000);
						System.out.println("Th3"+Thread.currentThread().getName()+":"+i);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			
		}).start();
		
		
		System.out.println("Th2");
		


		
				
		
	}
	
	
	
	
	public static void add(int x, int y) {
		System.out.println(x+y);
	}
	public static int getAdd(int x, int y) {
		return x+y;
	}
	//overload
	public static int getAdd(int x, int y, int z) {
		return x+y+z;
	}
	//overload //list를 매개변수로 받기 
	public static int getAdd(int ...numbers){
		int sum = 0;
		
		for(int i=0; i<numbers.length; i++) {
			sum += i;
		}
		return sum;
	}
	
	//Generic
	public static <T> void print(T type) {
		System.out.println(type);
	}


}

////기본 클래스 +생성자 + getter, setter + toString
//class Person{
//	
//	private String name;
//	private int age;
//	
//	public Person() {
//		
//	}
//	
//	Person(String name, int age){
//		this.name = name;
//		this.age = age;
//		
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	@Override
//	public String toString() {
//		
//		return "name: "+name+"age: "+age;
//		
//	}	
//}




////============================mac note============================
//[코테]
//
//이마트
//https://programmers.co.kr/tests/26207/test_token?token=c5d4e1c270751e82540d8d874be1af04
//
//카카오모빌리티
//
//
//
//
//
//
//——-———————————이클립스 단축키——————————————————
//https://goddaehee.tistory.com/134
//
//
//alt command s : get, set (이클립스)
//
//shift tab(탭 뒤)
//
//alt (이동)
//
//ctrl alt 위아래 (복사)
//
//ctl f11 run
//ctr shif f(줄맞춤)
//syso를 타이핑후 컨트롤+ 스페이스
//ctrl + l(라인이동)
//
//command + 7 (주석)
//
//
//
////값 포함 여부 체크
//map.containskey(값); => true/false
//list.indexOf(값); => 없으면 -1/있으면 해당인덱스번호
//
////대소문 변환
//.toUpperCase()
//.toLowerCase()
//
////문자열 동일값 비교
//-.equals() => true/false
//
////동일 Object 인지 체크
//… instanceof … -> true/false
//
////String 관련
//str.subString(0,15);
//.str.replace(“”,”’);
//.tri();
//str.split(“&|,|/.|_”);  // . 만 /.로 쓰기
//
////String <-> Integer, int
//int i = Integet.parseInt(str);
//String s = String.valueOf(i);
//
////String 을 배열로 저장
//String str=“abc”;
//str.length;
//str.charAt(인덱스번호);
//
////String -> char 배열에 저장 
//String str=“abc”;
//char[] arr;
//arr = str.toCharArray();
//
////String  -> String 배열에 저장 
//String str=“abc”;
//String[] arr;
//arr = str.split(“”);
//
////binary 연산
//int a=10;
//int b=8;
//int bin = a | b;
//Integer.toBinaryString(bin);
//
////replaceAll
//_.replaceAll(“/“,”#”);
//
////정규표현식
//Pattern p = Pattern.compile(정규표현식);
//Matcher m = p.matcher(비교할문자열);
//m.find();
//m.groupCount();
//m.group(1);
//
////char 사용시 유의
//(char)(‘0’+val);
//
////Math 라이브러리
//Math.pow();
//Math.Max();
//Math.Min();
//Math.round();
//Math.ceil();
//Math.floor();
//Math.random();
//
////배열 복사
//1
//char[] c = {‘a’,b’,c’};
//String cc = String.copyValueOf(c); => “abc”
//2
//System.arrayCopy(arr1,0,arr2,0,arr1.length);
//3
//arr.copyOf(원본배열, 복사할길이)
//4
//arr.copyOfRange(원본배열, 시작인덱스, 끝인덱스);
////Null 체크
//Object.isNull(Object obj) => null이면 true
//
////map
//for(타입 변수명 : 맵변수명.keySet()){
//	타입 value변수명 = 맵변수명.get(변수명);
//}
//
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
////Comparable -> compareTo() 메소드 vs Comparator -> compare( , ) 메소드
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
//=> return -1 (o1 < o2 -> -1) 오름차순
//     return 1 (o1 < o2 -> 1) 내림차순 
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
//
//￼
//
//
////정렬
//
//1.문자열정렬 
//
//-> char 배열에 저장 -> Arrays.sort() -> comb(arr,0,new StringBuilder());
//
//		for(String str : orders) {
//			char[] arr = str.toCharArray();
//			Arrays.sort(arr);
//			comb(arr,0,new StringBuilder());
//		}
