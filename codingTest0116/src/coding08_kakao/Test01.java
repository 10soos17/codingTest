package coding08_kakao;

import java.util.ArrayList;
import java.util.Collections;

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
public class Test01 {

	public static void main(String[] args) {

		String names = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
		// String names = "John Doe, Mary Jane Watson-Parker";
		String company = "ExamPle";

		// John Doe <jdoe@example.com>,
		// Peter Parker <pparker@example.com>, Mary Jane Watson-Parker
		// <mjwatsonpa@example.com>,
		// James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>,
		// Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>

		solution(names, company);

	}

	public static String solution(String names, String company) {

		String mail = "";
		String mailName = "";

		String[] list = names.split(", ");// 원래이름 리스트
		ArrayList<String> resList = new ArrayList<>();// 최종 메일 저장 리스트
		ArrayList<String> mailNameList = new ArrayList<>();// 메일에 사용할 이름 리스트

		for (String element : list) {


			String[] separateList = element.toLowerCase().split(" ");//이름 공백으로 2, 3부분
			String[] lastNameList = separateList[separateList.length-1].split("-");
			String lastName = "";

			if (lastNameList.length == 2) { //"-" 있을 경우
				lastName = lastNameList[0] + lastNameList[1];
				if (lastName.length() > 9) {//마지막 이름 길이 8자로 줄이기
					lastName = lastName.substring(0, 8);
				}
				mailName += separateList[0].charAt(0);
				mailName += separateList[1].charAt(0);
				mailName += lastName;

			} else { //"-" 없을 경우
				lastName = lastNameList[0];
				if (lastName.length() > 9) {//마지막 이름 길이 8자로 줄이기
					lastName = lastName.substring(0, 8);
				}
				mailName += separateList[0].charAt(0);
				mailName += lastName;
			}

			int count = Collections.frequency(mailNameList, mailName);
			mailNameList.add(mailName);

			if (count > 1) {
				mail += element+" <"+ mailName+count+"@"+company.toLowerCase()+".com>";
				resList.add(mail);
//        		System.out.println("numbering");
//        		System.out.println("mail:"+mail);

			}else if(count == 1) {
				int idx = mailNameList.indexOf(mailName);
				String tmp = resList.get(idx);
				String[] tmpList = tmp.split("@");
				mail+=tmpList[0]+1+"@"+tmpList[1];
				resList.set(idx, mail);

//        		System.out.println("change first");
//        		System.out.println("mail:"+mail);
			} else {
				mail += element+" <"+ mailName+"@"+company.toLowerCase()+".com>";
//        		System.out.println("add");
//        		System.out.println("mail:"+mail);
				resList.add(mail);
			}

			mail = "";
			mailName = "";
		}

		for (int i = 0; i < resList.size(); i++) {
			mail += resList.get(i);
			mail += ", ";
			if (i == resList.size() - 1) {
				mail += resList.get(i);
			}
		}
		System.out.println(mail);

		return mail;
	}
}
