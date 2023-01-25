package newCoding0423;

//프로그래머스 다른 풀이법들

import java.util.ArrayList;
import java.util.List;

class T7_removeNum2 {
//	배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
//	[1,1,3,3,0,1,1]	[1,3,0,1]
//  [4,4,4,3,3]	[4,3]

	public static void main(String[] args) {
		int[] nums = { 1, 3,3, 0, 1,1,1 };
		int[] s = solution(nums);
		for (int t : s) {

			System.out.println(t);
		}
		System.out.println("===");
		s = solution2(nums);
		for (int t : s) {

			System.out.println(t);
		}
	}

	public static int[] solution(int []arr) {
	     List<Integer> list = new ArrayList<>();
	     list.add(arr[0]);

	        for (int i = 1; i < arr.length; i++) {

	            if (arr[i] != arr[i - 1])
	                list.add(arr[i]);
	        }

	        int[] answer = new int[list.size()];

	        for (int i = 0; i < list.size(); i++)
	            answer[i] = list.get(i);

	        return answer;

	}
	public static int[] solution2(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
            System.out.println(answer[i]);
        }
        return answer;
	}


}