package newCoding0423;


class T16_feeCalc {
//	놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
//	놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
//	단, 금액이 부족하지 않으면 0을 return
//
//			price	money	count	result
//			3	20	4	10
//			30 (= 3+6+9+12) 이 되어 10만큼 부족하므로 10을 return


	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;

		long res = solution(price, money, count);
		System.out.println("res:"+res);

//		res = solution2(s);
//		System.out.println("res:"+res);
	}

	public static long solution(int price, int money, int count) {
		int answer= 0;
		int val = price;

		while(count>1) {
			price+=val*count;
			count--;
		}
		if(price<=money) return answer;

		answer=price-money;

		return answer;
	}


}