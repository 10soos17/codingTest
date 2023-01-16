package coding_naver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class Test3 {
	static int g;
	static int gp;
	static int start;
	static int end;
	public static void main(String[] args) {
/*
 * 
7 12 2

7 2
5 4
6 4
4 3
3 7
1 6
6 7
5 3
6 5
5 7
4 2
4 7

7 6 3
 */
		g = 2;
		gp = 7;
		start = 6;
		end = 3;
		
		int[][] arr = {
				{7, 2},
				{5, 4},
				{6, 4},
				{4, 3},
				{3, 7},
				{1, 6},
				{6, 7},
				{5, 3},
				{6, 5},
				{5, 7},
				{4, 2},
				{4, 7}};

		putPath(arr);
		//solution();
		
		
		

	}
	
	//정점별 간선, 가중치 자료구조 
		//map의 key = 정점
		//map의 value = ArrayList<ArrayList<Integer>>로 간선별 저장 
		public static HashMap<Integer, ArrayList<ArrayList<Integer>>> putPath(int [][] arr){
			HashMap<Integer, ArrayList<ArrayList<Integer>>> edge = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
			ArrayList<ArrayList<Integer>> mList = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> lList = new ArrayList<Integer>();
			
			lList.add(0);
			lList.add(0);
			mList.add(lList);
			edge.put(0, mList);

			
			for(int i=0;i<arr.length;i++) {
				int p = arr[i][0];
				int p2 = arr[i][1];
				//int w = arr[i][2];
				
				if (edge.get(p) != null) {
					mList = edge.get(p);
				} else {
					mList = new ArrayList<ArrayList<Integer>>();
				}
				lList = new ArrayList<Integer>();
				lList.add(p2);
				//lList.add(w);
				mList.add(lList);
				edge.put(p, mList);
				
			}


			for (int l : edge.keySet()) {
				System.out.println(l+":"+edge.get(l));
			}
			
			return edge;
			
		}
		

	public static void solution() {
		
		int []answer = {0};
			
		System.out.println(Arrays.toString(answer));
		
		
		
	}

}
