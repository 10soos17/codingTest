package newCoding1010;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* [방법]
 * 1. int
 *
 * 2. string
 * 
 * ====
 * 돌리기먼저
 * 
 * 조건구체화 
 *
 */



/*
2:28(4년마다 )
1,3,5,7,8,10,12: 31
4,6,9,11: 30
*/
//[방법1]
public class 팰린드롬_날짜 {

	//static List<Integer> ansewr = new ArrayList<>();
	static ArrayList<Integer>  list1;
	static ArrayList<Integer>  list2;
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	public static void main(String[] args) throws Exception {

		Integer[] dt1 = {1, 3, 5, 7, 8, 10, 12}; //31
		Integer[] dt2 = {4, 6, 9, 11}; //30
		list1 = new ArrayList<>(Arrays.asList(dt1));
		list2 = new ArrayList<>(Arrays.asList(dt2));

		/*
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)        
		LocalDate now = LocalDate.now();
		
		int today = Integer.parseInt(now.toString().replaceAll("-", ""));
		//LocalDate parisNow = LocalDate.now(ZoneId.of("Europe/Paris"));         
		for(int i = today; i >= 10101; i--){
			if(!check(i)) continue;
			int len = (i+"").length();
			if(palindrome(i, len)) {
				sb.append(i).append("\n");
				cnt++;
			}
			
		}
		System.out.println(sb.toString());
		System.out.println(cnt);
		*/
		// 태어날 날짜 펠린드롬
		String birthday = "1994-04-23T00:00:00.000";//"1985-10-17T00:00:00.000";//"1994-04-23T00:00:00.000";//
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		Date bFormat = df.parse(birthday);
		//System.out.println(bFormat);
		long bTS = bFormat.getTime();
		Timestamp bText = new Timestamp(bFormat.getTime());//instead of date put your converted date
		//System.out.println(bTS);
		
		long nowTS = System.currentTimeMillis();// 날짜 -> 타임스탬프
		Timestamp nowText = new Timestamp(nowTS);// 타임스탬프 -> 날짜
		long diff = nowTS - bTS;
		long dDay = 5000000000L;//diff / (24*60*60*1000);
		//System.out.println(dDay);
		
		List<long[]> days = new ArrayList<>();
		for(long i = 0; i < dDay; i++) {
			int bLen = (i+"").length();
			if(palindrome(i, bLen)) {
				// 태어난지 i후 -> 날짜로변환
				long thisTS = bTS + (i * 24*60*60*1000);
				Timestamp thisText = new Timestamp(thisTS);
				String thisFormat = df.format(thisText);
				long thisDate = Long.parseLong(thisFormat.split("T")[0].replaceAll("-", ""));
				//System.out.println("thisDday:"+i);
				//System.out.println("thisDate:"+thisDate);
				if(dDayCheck(thisDate)) {
					int thisLen = (thisDate+"").length();
					if(palindrome(thisDate, thisLen)) {
						days.add(new long[] {i, thisDate, i/365 });
					}
				}
				
			}
		}
		for(long[] d: days) {
			System.out.println(Arrays.toString(d));
		}
		System.out.println(days.size());
		
		
	}
	
	static boolean check(int today) {
		//int numLen = (today+"").length();
		int year = today / (int)Math.pow(10, 4);
		int month = today % (int)Math.pow(10, 4) / 100;
		int M1 = month / 10;//today % (int)Math.pow(10, 4) / 1000;
		int M2 = month % 10;//today % (int)Math.pow(10, 3) / 100;
		int date = today % (int)Math.pow(10, 2);
		int D1 = date / 10; //today % (int)Math.pow(10, 2) / 10;
		int D2 = date % 10;//today % (int)Math.pow(10, 1);
		//System.out.println(M1);
		
		// 30일까지 있는 달
		if (list2.contains(month) && date == 31) return false;
		
		// 윤달
		if(month == 2) {
			if(year % 4 != 0 && date > 28) return false;
			else if(year % 4 == 0 && date > 29) return false;
		}
		//그 외
		if(month  == 0 || date == 0) return false;
		if(month > 12 || date > 31) return false;

		return true;
	}
	
	static boolean palindrome(long today, int len) {
		long point = (int)len / 2;
			long fd;
			long f;
			long b;

			if(len % 2 == 0) { //	
				fd = (int)Math.pow(10, len - point);

				f = today / fd; 
				b = today % fd;
				//System.out.println(fd + ":" + f + ":" + b);
				
			}else { // 홀
				fd = (int)Math.pow(10, len - point);

				f = today / fd; 
				b = today % (fd / 10);
				//System.out.println("rets");
				//System.out.println(fd + ":" + f + ":" + b);
			}
			int numLen = (f+"").length();
			for(long i = 0; i < numLen; i ++) {
				long fn = f / (long)Math.pow(10, numLen - i - 1) % 10;
				long bn = b / (long)Math.pow(10, i) % 10;
				if(fn != bn) return false;
				
			}
			return true;
	}
	
	// 펠린드롬 시리즈2
	// 조건 1. 태어날 일자로부터 며칠 
	// 조건 2. 연월일 
	// 모두 충족 시, 개수와 [[1번][2번]] 이중 배열로 리턴

	static boolean dDayCheck(long today) {
		//int numLen = (today+"").length();
		long year = today / (long)Math.pow(10, 4);
		long month = today % (long)Math.pow(10, 4) / 100;
		long M1 = month / 10;//today % (int)Math.pow(10, 4) / 1000;
		long M2 = month % 10;//today % (int)Math.pow(10, 3) / 100;
		long date = today % (long)Math.pow(10, 2);
		long D1 = date / 10; //today % (int)Math.pow(10, 2) / 10;
		long D2 = date % 10;//today % (int)Math.pow(10, 1);
		//System.out.println(M1);
		
		// 30일까지 있는 달
		if (list2.contains(month) && date == 31) return false;
		
		// 윤달
		if(month == 2) {
			if(year % 4 != 0 && date > 28) return false;
			else if(year % 4 == 0 && date > 29) return false;
		}
		//그 외
		if(month  == 0 || date == 0) return false;
		if(month > 12 || date > 31) return false;

		return true;
	}
	
	
}









