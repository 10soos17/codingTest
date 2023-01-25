package coding01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//JVM에서 RAM 영역 나누기
//(1)Stack영역: 변수 저장
//(2)Heap영역: 생성 객체 저장
//(3)메소드영역: 공유(static)

//public: 모든 패키지에서
//protected: 패키지 안에서만 + 패키지가 다른 경우는 상속관계 설정에서 사용 가능(변수, 생성자, 메소드에서 사용)
//default: 같은 패키지에서만(클래스, 변수, 생성자, 메소드에서 사용)
//private: 하나의 클래스 안(변수, 생성자, 메소드에서 사용)
//Singleton: 클래스 내에서 생성된 객체를 메소드에서 호출해서 사용하는 형태 (생성된 객체 주소값 반복적 호출)

//Abstract Class : 추상 메소드가 존재할 때, "abstract"를 붙인다.
//강제성, 일관성을 지키기 위해서 사용
//객체 생성 불가 => 자식을 통한 객체 생성 가능, 재정의 가능
//interface 와의 차이 : interface는 다중 상속 가능. 그외 동일

//interface:(Java8버전부터)상수, 추상 메소드, default(), static() 사용, 상속 시 implements

//클래스에는 protected, private불가


//클래스 앞에 final: 상속 금지(부모 클래스가 될 수 없음)
//메소드 앞에 final: Overriding 금지(재정의)
//변수 앞에 final: 고정상수(값 변경 불가)

//PolyMorphism(다형성): 여러개의 개별적인 클래스를 하나의 부모 클래스 객체로 통합관리 효율성을 높인 것
//하나의 부모 타입으로 생성된 여러 자식객체를 가리키는 것
//instanceof 연산자 :: Polymorphism 사용을 위한 형변환 가능 여부 판별

//Polymorphism 종류: (1)변수의(Field)의 다형성
//					(2)Method의 다형성
//					(3)Parameter의 다형성
//					(4)Array의 다형성
//					(5)Abstract Class의 다형성
//					(6)Interface의 다형성

//익명 구현 객체: 원래 클래스에서 정의된 메소드만 재정의해서 사용할 수 있음. 새 메소드 정의해도 사용 불가
//ex. 클래스명 변수명 = new 클래스명(){메소드 재정의해서 사용 가능 };

//Lambda Expression: 익명구현객체를 간단히 표현, "()->"
//Lambda Expression 조건: (1) 인터페이스
//					     (2) 추상 메소드가 하나인 인터페이스
//					     (3) 인터페이스 위에 @FunctionalInterface 쓰여 있으면 가능
//					     	(예) @FunctionalInterface
//					     		public interface Runnable

//Compare(오름,내림차순): Comparable: 우리가 만든 클래스에 대한 객체 비교시 Comparable를 재정의 해서 사용해야 비교( 가능
//: 일반적인 정렬시 사용
//Comparator: 특수한 정렬을 요할때 사용
public class ClassRehearse_Basic {

	public static void main(String[] args) {
//=================== String etc.=========================================================
		String ssn2 = "010244-1230123";
		char k = ssn2.charAt(7);
		ssn2.substring(3,7);
		int index = ssn2.indexOf("-");
		ssn2.replace("010", "020");
//=================== String <-> Integer=========================================================
		int int1 = Integer.parseInt("11");
		String str1 = String.valueOf(int1);

//===================random============================================================================
		int answer = (int) (Math.random() * 100) + 1;// 1~100
		int num11 = (int) (Math.random() * 6) + 1;// 임의의 주사위 눈 출력하기
		System.out.println(num11);
		// 난수출력
		Random ran = new Random();
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt());

		// 난수출력
		Random ran2 = new Random(100L);// long seed: 종자값
		System.out.println(ran2.nextInt(100));
		System.out.println(ran2.nextInt(100));
		System.out.println(ran2.nextFloat());
		System.out.println(ran2.nextFloat());
//===================0.아스키============================================================================
		int charCode = 'A'; // 자동형변환
		System.out.println(charCode); // 65

		if (charCode >= 65 & charCode <= 90) {
			System.out.println("대문자 입니다.");
		}
		if (charCode >= 97 & charCode <= 122) {
			System.out.println("소문자 입니다.");
		}
		if (charCode >= 48 & charCode <= 57) {
			System.out.println("0~9 입니다.");
		}
//=================== String <-> Byte=========================================================
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str11 = new String(bytes);
		System.out.println(str11);

		String str22 = new String(bytes,6,4);
		System.out.println(str22);
//===================String -> split =========================================================
		String txt = "홍길동&알파고,베타고.김일동-최명호";
		String[] names = txt.split("&|,|\\.|-");
//===================String -> split =========================================================
		String str2 = "사과=10|초콜릿=3|샴페인=1";

		StringTokenizer st2 = new StringTokenizer(str2, "=|", true);

		while (st2.hasMoreTokens()) {
			String name = st2.nextToken();
			if (name.equals("=")) {
				System.out.print("\t");
			} else if (name.equals("|")) {
				System.out.print("\n");
			} else {
				System.out.print(name + " ");
			}

		}
//=================== 1.전위연산자 vs 후위연산자=========================================================
		int x = 10;
		int y = 10;
		int z;

		// System.out.println(x++); //10
		// System.out.println(x); //11

		x++;// 11
		++x;// 12
		System.out.println("x= " + x);
		// System.out.println(x);

		y--;
		--y;
		System.out.println("y= " + y);// 8

		z = x++;
		System.out.println("z= " + z);// 12
		System.out.println("x= " + x);// 13

		z = ++x;
		System.out.println("z= " + z);// 14
		System.out.println("x= " + x);// 14

		z = ++x + y++;// 15 + 8
		System.out.println("z= " + z);// 23
		System.out.println("x= " + x);// 15
		System.out.println("y= " + y);// 9

//=================== 2.Formatted output in Java=========================================================
		double d = 301.2345;
		System.out.printf("Formatted to right margin: n = %5.2f\n", d);
		int s = 30;
		System.out.printf("Formatted to right margin: n = %d\n", s);
		char c1 = 'A';
		System.out.printf("%c", c1);

//=================== 3.비트 연산=========================================================
		int xx = 8;
		int yy = 3;
		int result = 0;
		boolean bResult = false;

		/*
		 * 비트로 변경 8: 00000000 00000000 00000000 00001000 3: 00000000 00000000 00000000
		 * 00000011
		 */

		// &
		System.out.println("x & y = " + (xx & yy));
		System.out.println("true & false = " + bResult);

		// |
		System.out.println("x | y = " + (xx | yy));
		System.out.println("true & false = " + !bResult);
		// ^ : XOR ,두 피연산자의 대응되는 비트에서 서로 같은 경우에는 0을, 다른 경우에는 1을 반환
		System.out.println("x ^ y = " + (xx ^ yy));
		System.out.println("true ^ false = " + !bResult);

		/*
		 * int v1 = 10; //00000000 00000000 00000000 00001010 int v2 = ~v1; //11111111
		 * 11111111 11111111 11110101(-11) ~: not(bit연산에서) int v3 = ~v1 + 1; //11111111
		 * 11111111 11111111 11110110(-10) System.out.println(bo.toBinaryString(v1) +
		 * "(십진수: " + v1 + ")"); System.out.println(bo.toBinaryString(v2) + "(십진수: " +
		 * v2 + ")"); System.out.println(bo.toBinaryString(v3) + "(십진수: " + v3 + ")");
		 * System.out.println();
		 *
		 * int v4 = -10; //11111111 11111111 11111111 11110110(-10) int v5 = ~v4;
		 * //00000000 00000000 00000000 00001001(9) ~: not(bit연산에서) int v6 = ~v4 + 1;
		 * //00000000 00000000 00000000 00001010(10)
		 * System.out.println(bo.toBinaryString(v4) + "(십진수: " + v4 + ")");
		 * System.out.println(bo.toBinaryString(v5) + "(십진수: " + v5 + ")");
		 * System.out.println(bo.toBinaryString(v6) + "(십진수: " + v6 + ")");
		 * System.out.println();
		 */
		System.out.println("1 << 3   = " + (1 << 3));// 왼쪽으로 이동, 부호비트 없음, 빈 공간을 0으로 채움
		System.out.println("-8 >> 3  = " + (-8 >> 3)); // 오른쪽으로 이동, 왼쪽 최상위비트(양수:0,음수:1)로 공간을 채움
		System.out.println("-8 >>> 3 = " + (-8 >>> 3)); // 오른쪽으로 이동, 이동한만큼 왼쪽 최상위비트부터 무조건 0으로 채움
		System.out.println("1     	:" + toBinaryString(1));
		System.out.println("1<<3  	:" + toBinaryString(1 << 3));
		System.out.println("-8    	:" + toBinaryString(-8));
		System.out.println("-8>>3	:" + toBinaryString(-8 >> 3));
		System.out.println("-8>>>3	:" + toBinaryString(-8 >>> 3));

//=================== 4. System.in.read() 키보드 입력 컨트롤 - keycode=========================================================
		boolean run = true;
		int keyCode = 0;
		int speed = 0;

		while (run) {
			// 키보드 "Enter' 누르면: 코드값 10(Line Feed) + 13(Carriage Return) 동작
			if (keyCode != 13 && keyCode != 10) {
				System.out.println("------------------");
				System.out.println("1.종속 2.감속 3.중지 ");
				System.out.println("------------------");
				System.out.println("------------------");
				System.out.println("선택: ");

			}

			try {
				keyCode = System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.println(keyCode);

			if (keyCode == 49) {// 키보드에서 1을 눌렀을 때 - 종속
				speed++;
				System.out.println("현재속도: " + speed);

			} else if (keyCode == 50) {// 키보드에서 2을 눌렀을 때 - 속
				speed--;
				System.out.println("현재속도: " + speed);
			}

			else if (keyCode == 51) {// 키보드에서 3을 눌렀을 때
				run = false;
			}
			System.out.println("프로그램 종료");
		}
//===================5. Time 관련 라이브러리 -> Calendar, LocalDate=========================================================
		// Calendar Class 추상클래스이므로 자식 객체 생성 대신 Singleton 형식으로 클래스 내용 사용
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		int day = cal.get(Calendar.DATE);
		System.out.println(year + "/" + month + "/" + day);

		// import java.time.LocalDate;
		LocalDate cd = LocalDate.now();
		System.out.println("현재날짜: " + cd);

		LocalTime ct = LocalTime.now();
		System.out.println("현재시간: " + ct);

		LocalDateTime cdt = LocalDateTime.now();
		System.out.println("현재날짜와 시간: " + cdt);

		System.out.println(cdt.getYear()+"년");
		System.out.println(cdt.getMonthValue()+"월");
		System.out.println(cdt.getDayOfMonth()+"일");
		System.out.println(cdt.getHour()+"시");
		System.out.println(cdt.getMinute()+"분");
		System.out.println(cdt.getSecond()+"초");

		ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("협정 세계시: " + utc);

		ZonedDateTime utc2 = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println("서울 시간존: " + utc2);

		//Date, SimpleDateFormat
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일 HH:mm");
		System.out.println(sdf.format(now));

		HashMap<Integer, String> dayMap = new HashMap<>();
		dayMap.put(0, "일요일");
		dayMap.put(1, "월요일");
		dayMap.put(2, "화요일");
		dayMap.put(3, "수요일");
		dayMap.put(4, "목요일");
		dayMap.put(5, "금요일");
		dayMap.put(6, "토요일");

		String day1 = dayMap.get(now.getDay());

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH시 mm분");

		System.out.println(sdf1.format(now) + " " + day1 + " " + sdf2.format(now));

//===================7.정규표현식=========================================================
		String source = "HP:010-1111-1111," + "HOME:02-999-9999";

		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		int i = 0;
		while (m.find()) {
			System.out.println(++i + " : "
		+ m.group() + " => "+m.group(1)+", "+m.group(2)+", "+m.group(3));

		}
//===================숫자포맷 - DecimalFormat=========================================================
		DecimalFormat df1 = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#,###E0");

		try {
			//Number Class: Byte, Double, Float, Integer, Long, Short
			Number num = df1.parse("1,234,567.89");
			System.out.println("1,234,567.89"+"=> "+num);
			double dd = num.doubleValue();
			System.out.println(dd+"=>"+df2.format(num));
		} catch (ParseException e) {
			System.out.println("변화 불가");
		}

		double num = 1234567.89;
		DecimalFormat df3 = new DecimalFormat("0");
		System.out.println(df3.format(num));
		DecimalFormat df4 = new DecimalFormat("0.0");
		System.out.println(df4.format(num));
		DecimalFormat df5 = new DecimalFormat("0000000000.000000");
		System.out.println(df5.format(num));
		DecimalFormat df6 = new DecimalFormat("##,###,###,###.######");
		System.out.println(df6.format(num));

//===================네트워크===========================================================================
		String name = "www.google.com";
	       try {
			InetAddress id = InetAddress.getByName(name);
			String hostname = id.getHostName();
			String hostAddress = id.getHostAddress();
			System.out.println(hostname+" : "+ hostAddress);
		} catch (UnknownHostException e) {

		}

//===================Thread============================================================================
//		Runnable beepTask = new BeepTask();
//		Thread th1 = new Thread(beepTask);
//		th1.start();
//
//		for (int i = 0; i < 5; i++) {
//			System.out.println("띵");
//			try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//
//			}
//		}
//
//		// 2 Runnable 익명객체
//		Thread th2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				Toolkit tk = Toolkit.getDefaultToolkit();
//				for (int i = 0; i < 5; i++) {
//					tk.beep();
//					try {
//						Thread.sleep(500);
//					} catch (Exception e) {
//					}
//				}
//			}
//		});
//
//		// 3 람다식 이용
//		Thread th3 = new Thread(() -> {
//			Toolkit tk = Toolkit.getDefaultToolkit();
//			for (int i = 0; i < 5; i++) {
//				tk.beep();
//				try {
//					Thread.sleep(500);
//				} catch (Exception e) {
//
//				}
//			}
//		});




	}

	public static String toBinaryString(int value) {

		String str = Integer.toBinaryString(value);

		while (str.length() < 32) {
			str = "0" + str;
		}
		return str;

	}

}
