package newCoding0821_HS;

import java.util.Arrays;

//아홉 난쟁이는 각각 자신이 백설공주의 일곱 난쟁이라고 우기고 있다.
//난쟁이가 쓰고 다니는 모자에 100보다 작은 양의 정수를 적어 놓았다.
//일곱 난쟁이의 모자에 쓰여 있는 숫자의 합이 100이 되도록 적어 놓았다.
//
//아홉 난쟁이의 모자에 쓰여 있는 수가 주어졌을 때, 일곱 난쟁이를 찾는 프로그램을 작성하시오.
//(아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾으시오)
//
//입력
//총 아홉개 줄에 1보다 크거나 같고 99보다 작거나 같은 자연수가 주어짐
//출력
//일곱 난쟁이가 쓴 모자에 쓰여 있는 수를 한 줄에 하나씩 출력
//{7, 8, 10,13,15,19,20,23,25}
public class T_BJ_Combination_01 {

	static int[] n = { 7, 8, 10, 13, 15, 19, 20, 23, 25 };

	public static void main(String[] args) {
		int limit=7;
		int[] temp = {0,0,0,0,0,0,0};
		getCombination(limit,temp,0,0);
	}


	public static void getCombination(int limit, int[] temp, int current, int start) {

		if(limit == current) {
			int sum=0;
			System.out.println("==="+temp[6]);
			for(int i : temp) {
				sum+=i;
			}
			if(sum==100) {
				System.out.println(Arrays.toString(temp));
			}
		}else {

			for(int i=start;i<n.length;i++) {
				temp[current] = n[i];
				getCombination(limit,temp,current + 1, i + 1);

			}
		}

	}

}
