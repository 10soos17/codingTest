package coding_AlgoBasic;

import java.util.HashMap;

//https://www.youtube.com/watch?v=5BRmT4VTEpo&list=PLDV-cCQnUlIZOsYWdD5u1Qo3ByXoC6CmZ&index=4
//anagram : 동일한 알파벳으로 형성된 문자열 묶기
//시간복잡도: m*logn(n개의알파벳을정렬하는시간) * n(배열안의 문자열 개수) = o(n*m*logn)
//공간복잡도:
public class String2_LongestString_noRepeat {

	public static void main(String[] args) {

		String[] arr1 = { "a", "b", "c", "g", "g", "a", "b", "d", "f", "h","h","g"};
		solution(arr1);

	}

	//(포인터 2개) 시작인덱스, 끝인덱스
	//(데이터저장) 최대길이, 문자열
	//두 포인터 첫 인덱스로 세팅
	// -> 끝인덱스 +1 && hashmap에 해당 알파벳 있었는 지 체크
	// -> 있으면 그리고 첫인덱스알파벳과 끝인덱스 알파벳이 같으면, 첫인덱스를 hashmap에 저장되어 있던 위치+1로 이동 &&  hashmap에 알파벳 인덱스 저장
	//    없으면 끝인덱스 +1 && 최대길이 리셋 &&  hashmap에 알파벳 인덱스 저장
	public static void solution(String[] nums) {

		HashMap<String, Integer> map = new HashMap<>();
		int begin=0;
		int finish=0;
		int maxLen=1;
		String maxStr="";
		String s="";

		while(finish < nums.length) {


			int check = checkData(nums[finish], finish, map);


			if( check != -1 && begin < check) {
				maxLen = finish-begin;
				maxStr= s;

				begin = check+1;
				//System.out.println("begin:"+begin+"finish:"+finish);
				s="";
				for(int i=begin;i<finish;i++) {
					s+=nums[i];
				}
//				System.out.println("11111");
//				System.out.println(maxLen);
//				System.out.println(s);
//				System.out.println();
			}else {
				s+=nums[finish];
				finish+=1;
				if(maxLen<finish-begin) {
					maxLen=finish-begin;
					maxStr=s;
				}
//				System.out.println("begin:"+begin+"finish:"+finish);
//				System.out.println("22222");
//				System.out.println(maxLen);
//				System.out.println(s);
//				System.out.println();

			}

		}

		System.out.println(maxLen+":"+maxStr);

		for(String str:map.keySet()) {
			System.out.println(str+":"+map.get(str));
		}


	}

	//map에 데이터 있는 지, 체크 && value에 인덱스 넣기
	//-> 데이터 있으면 value 리턴
	public static int checkData(String str, int finish, HashMap<String, Integer> map) {

		if(map.get(str)!=null) {
			int idx = map.get(str);
			map.put(str,finish);
			return idx;
		}else {
			map.put(str,finish);
			return -1;
		}
	}







}