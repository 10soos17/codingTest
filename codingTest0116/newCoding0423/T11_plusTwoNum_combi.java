package newCoding0423;

import java.util.TreeSet;

class T11_plusTwoNum_combi {
//	numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 
//			numbers	result
//			[2,1,3,4,1]	[2,3,4,5,6,7]
//			[5,0,2,7]	[2,5,7,9,12]
	//TreeSet관련
	//descendingIterator()내림차순으로 정렬된 Iterator를 리턴
	//descendingSet()내림차순으로 정렬된 NavigableSet을 반환
	
	static TreeSet<Integer> answer = new TreeSet<>();
	static int r =2;
	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		int sum=0;
		TreeSet<Integer> res = solution(numbers, 0, 0, sum);
		System.out.println(res);
		
	}

	public static TreeSet<Integer> solution(int[] numbers, int current, int start, int sum) {

		if (r == current) {
			System.out.println(sum);
			answer.add(sum);
		} else {
			for (int i = start; i < numbers.length; i++) {
				int summ=sum+numbers[i];
				solution(numbers, current + 1, i + 1, summ);			
			}
		}

		return answer;
	}

}