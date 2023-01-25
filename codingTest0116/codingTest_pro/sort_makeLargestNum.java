package codingTest_pro;

import java.util.Arrays;
import java.util.Comparator;

public class sort_makeLargestNum {

	public static void main(String[] args) {
		//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]] ->	[5, 6, 3]
		int [] arr1 = {3, 0, 6, 1, 5};//3


		solution(arr1);

	}

    public static String solution(int[] numbers) {
		String answer = "";
        String[] str = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {

            @Override
			public int compare(String val1, String val2){
                return (val2+val1).compareTo(val1+val2);
            }
        });
        System.out.println(Arrays.toString(str));

        for (String element : str) {
            answer+=element;
        }

        return answer;
    }
}