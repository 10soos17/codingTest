package coding_naver;

import java.util.ArrayList;
import java.util.Scanner;

////char 사용시 유의
//(char)(‘0’+val);

////값 포함 여부 체크
//map.containskey(값); => true/false
//list.indexOf(값); => 없으면 -1/있으면 해당인덱스번호

////배열 복사
// Array -> List로 복사
//String[] str = { "d", "a", "b", "c" };
//List<String> list11 = Arrays.asList(str);

//System.arrayCopy(arr1,0,arr2,0,arr1.length);

//arr.copyOf(원본배열, 복사할길이)

//arr.copyOfRange(원본배열, 시작인덱스, 끝인덱스);

////Null 체크
//Object.isNull(Object obj) => null이면 true

////map
//for(타입 변수명 : 맵변수명.keySet()){
//타입 value변수명 = 맵변수명.get(변수명);
//}

//Collections.sort(배열이름);
//Collections.reverse(배열이름);

//String str=“abc”;
//char[] arr;
//arr = str.toCharArray();

//char[] c = {‘a’,b’,c’};
//String cc = String.copyValueOf(c); => “abc”

//int bin = a | b;
//Integer.toBinaryString(bin);

////정규표현식
//Pattern p = Pattern.compile(정규표현식);
//Matcher m = p.matcher(비교할문자열);
//m.find();
//m.groupCount();
//m.group(1);

//ArrayList<Integer> list = new ArrayList<>();
//HashMap<String, Integer> map = new HashMap<>();
public class Test2 {

	 //표준입력을 수행할 Scanner를 선언한다
    public static Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseNum)
    {   //하나의 테스트케이스를 처리하는 함수
        //각 테스트케이스에 대하여 데이터를 입력받고 정답을 출력하세요

    	int n = 10;//scanner.nextInt();
		int m = 3;//scanner.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
//		int[] arr = new int[n];
//		for(int i = 0 ; i < n ; i ++)
//		{
//			arr[i] = scanner.nextInt();
//		}

		arr.add(123123123);
		arr.add(234234234);
		arr.add(234234234);
		arr.add(123123123);
		arr.add(345345345);
		arr.add(123456789);
		arr.add(987654321);
		arr.add(123789456);
		arr.add(456123789);
		arr.add(987987789);

		solution(m,arr);

    }


	public static void solution(int m, ArrayList<Integer> arr) {

		int answer=0;
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0;i<arr.size();i++) {
			if(cnt == m) {
				answer=i;
				break;
			}
			else if(i==arr.size()-1){
				answer=i+1;
				break;
			}
			else if(list.indexOf(arr.get(i)) ==-1) {

				list.add(arr.get(i));
				cnt+=1;
			}

		}
		System.out.println(answer);


	}

    public static void main(String[] args)
    {   //프로그램의 시작부
        int tn = 2; //테스트케이스의 수를 입력받는다
        for(int caseNum = 1 ; caseNum <= tn ; caseNum++)
        {   //테스트케이스의 수 만큼 반복 수행한다
            testCase(caseNum);
        }
    }




}
