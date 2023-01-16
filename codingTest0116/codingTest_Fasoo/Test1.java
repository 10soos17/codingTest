package codingTest_Fasoo;

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
public class Test1 {
	static int check;

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();

		/*
		 * 
		 * 
		 * 
		 */
		int[] arr = {1,1,0,1,1,0,0,0,1};// { 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1 };// {1,1,0,1,1,0,0,0,1};
		int[] arr2 = {};

		int r = 3;//5;
		int c = 3;//3;

		solution(r, c, arr);

	}

	public static int[] solution(int r, int c, int[] bombmap) {
		int[] answer = new int[2];
		int[][] matrix = new int[r][c];
		int cnt = 0;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				matrix[i][j] = bombmap[cnt];
				cnt++;
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();
		}
		
		
		int n = 0;
		

		for (int i = 0; i < r - 1; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == matrix[i + 1][j]) {
					System.out.println("ss:" + matrix[i][j]);
					n += 1;

				} else {
					n = 0;
					break;
				}
			}

			if (n == c) {
				if (i == r - 2) {
					for (int k = 0; k < c; k++) {
						matrix[i + 1][k] = -1;
						System.out.println("same:" + matrix[i + 1][k]);
					}
				} else {
					for (int k = 0; k < c; k++) {
						matrix[i][k] = -1;
						System.out.println("same:" + matrix[i][k]);
					}
				}
				n = 0;
			}
			//
			for (int t = 0; t < r; t++) {
				for (int tt = 0; tt < c; tt++) {
					System.out.print(matrix[t][tt] + " ");

				}
				System.out.println();
			}

		}
		
		System.out.println("next");
		
		for (int i = 0; i < c-1; i++) {
			for (int j = 0; j < r; j++) {
				
				if(matrix[j][i] == matrix[j][i+1]) {
					System.out.println("ss:" + matrix[i][j]);
					n+=1;
				}else {
					n=0;
					break;
				}
				
			}
			
			if (n == r) {
				if (i == c - 2) {
					for (int k = 0; k < r; k++) {
						matrix[k][i+1] = -1;
						System.out.println("same:" + matrix[k][i+1]);
					}
				} else {
					for (int k = 0; k < r; k++) {
						matrix[k][i] = -1;
						System.out.println("same:" + matrix[k][i]);
					}
				}
				n = 0;
			}
			//
			for (int t = 0; t < r; t++) {
				for (int tt = 0; tt < c; tt++) {
					System.out.print(matrix[t][tt] + " ");

				}
				System.out.println();
			}
			
		}
	
		
		

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(matrix[i][j]==1) {
					
					answer[0]++;
				}else if(matrix[i][j]==0) {
					
					answer[1]++;
				}
			}
			
		}

		System.out.println(Arrays.toString(answer));
		
		
		

		return answer;
	}

}
