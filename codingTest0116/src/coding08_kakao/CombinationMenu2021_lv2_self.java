package coding08_kakao;

public class CombinationMenu2021_lv2_self {

	public static void main(String[] args) {



		/*
		 * orders	course	result
			["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
			["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
			["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
		 */

		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};

		solution(orders, course);
	}


	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};

		for(int i=1;i<orders.length;i++) {

			int min = orders[i].length();
			int idx = i;


			while(idx > 0 && orders[idx-1].length() > min) {
				String tmp = orders[idx];
				orders[idx] = orders[idx-1];
				orders[idx-1] = tmp;
				idx -=1;

			}
		}

//		for(int i=0;i<orders.length;i++) {
//		System.out.println(orders[i]);
//		}
//		//Collections.sort(orders);
		int count = 0;
		String menu="";

		for (int element : course) {
			for (String order : orders) {

				if(order.length() < element) {
					continue;

				}else {

					String[] str = order.split("");
					//각 문자열 루프
					for (String element2 : str) {


						//다음 orders 비교 루프
						for(int h=1;h<orders.length;h++) {

							//다음 문자열 내부 찾기
							if(orders[h].indexOf(element2) != -1) {
								count++;
							}

						}




				}
			}
		}



		}







		return answer;

	}
}
