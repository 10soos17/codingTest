package Test7_devMatching1001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//order by sum(salary) desc

//SELECT distinct experience exp, count(experience) count from assessments group by exp;

class T1 {

//	static int r = 3;
//	static int[] l = { 1,2,7,6,4};
//	static int sum=0;
//	static int cnt=0;
	public static void main(String[] args) {

		String id = "bird100";

		int n = 7;
		int m = 24;
		int p = 4;

		int[] l = { 2, 4 };
		int[] ll = { 1, 3, 5 };

		String[] idList = {"bird99", "bird98", "bird101", "gotoxy"};
		String[] sll = {};

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };

		String res = solution(idList, id);
		System.out.println(res);

	}

	public static String solution(String[] idList, String id) {
		String answer = id;

		// List<String> list = new ArrayList<>();
		Map<String, int[]> map = new HashMap<>();

		for (String s : idList) {

			String reg = "[0-9]{0,6}$";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(s);
			m.find();

			String regS = "^[a-z]{3,6}";
			Pattern pS = Pattern.compile(regS);
			Matcher mS = pS.matcher(s);

			mS.find();
			String key = mS.group(0);

			int tmp = 0;
			if (!m.group(0).isEmpty()) {
				tmp = Integer.parseInt(m.group(0));
			}

			System.out.println(key+":"+tmp);

			if(map.containsKey(key)) {
				int[] nums = new int[map.get(key).length + 1];

				for(int i=0;i<nums.length-1;i++) {
					nums[i]=map.get(key)[i];
				}
				nums[map.get(key).length] = tmp;
				map.put(key, nums);

			} else {
				map.put(key, new int[] {tmp});
			}

		}

	for(String s:map.keySet()) {
		System.out.println(map.get(s).length);
		System.out.println(Arrays.toString(map.get(s)));

	}

		String reg = "^[a-z]{3,6}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(id);

		m.find();

		String myKey = m.group(0);
		System.out.println(myKey);

		if (map.containsKey(myKey)) {

			System.out.println("new" +map.get(myKey));

			int[] num = map.get(myKey);

			Arrays.sort(num);
			for (int i = 1; i < num.length - 1; i++) {
				if (num[i] - num[i - 1] > 1) {
					int n = num[i - 1] + 1;
					answer = myKey+n;
				}
				if (i == num.length - 1) {
					int n = num[i - 1] + 1;
					answer = myKey+n;
				}
			}

		}

		return answer;
	}

}