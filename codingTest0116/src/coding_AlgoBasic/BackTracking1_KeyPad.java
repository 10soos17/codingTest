package coding_AlgoBasic;

import java.util.ArrayList;

public class BackTracking1_KeyPad {


	public static void main(String[] args) {

		//=====1
		solution1();

		//=====2
		int[] arr1 = new int[] { 1, 2, 3 };
		ArrayList<Integer> list1 = new ArrayList<>();
		subset(0, arr1, list1);
		for(ArrayList<Integer> i: subSet) {
			System.out.println(i);
		}

		//=====3
		int[] arr2 = new int[] { 1, 2, 3 };
		ArrayList<Integer> list2 = new ArrayList<>();
		permutation(arr2,list2);
		for(ArrayList<Integer> i: perms) {
			System.out.println(i);
		}


	}

	//https://www.youtube.com/watch?v=Ar40zcPoKEI&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=2
	//문제: 숫자 패드로 조합할수있는 모든 문자를 return하여라
	static ArrayList<String> comb = new ArrayList<>();
	static String[] keypad = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static String target = "259";

	public static void solution1() {

		if(target.length() == 0) {
			return;
		}

		ArrayList<String> list = new ArrayList<>();
		keyPadComb(0, list);

		System.out.println(comb.size());
		for(String s:comb) {
			System.out.println(s);
		}
	}


	public static void keyPadComb(int num, ArrayList<String> list) {

		if(num == target.length()) {
			String str="";
			for(String s:list) {
				str+=s;
			}
			comb.add(str);
			return;
		}

		String[] nums = target.split("");
		int idx = Integer.parseInt(nums[num]);

		String[] text = keypad[idx].split("");

		for (String element : text) {
			list.add(element);
			keyPadComb(num+1,list);
			list.remove(list.size()-1);
		}
	}

	//https://www.youtube.com/watch?v=gVijWUHWzAU&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=3
	//문제: nums로 주어진 숫자로 만들수 있는 subsets들을 return하여라
	static ArrayList<ArrayList<Integer>> subSet = new ArrayList<>();

	public static void subset(int num, int[] arr, ArrayList<Integer> list) {

		if (num == arr.length) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int i : list) {
				l.add(i);
			}
			subSet.add(l);
			return;
		}

		int val = arr[num];

		subset(num+1,arr, list);

		list.add(val);
		subset(num+1,arr,list);
		list.remove(list.size()-1);

	}

	//https://www.youtube.com/watch?v=lhy9mtUqZGc&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=4
	//문제: nums로 주어진 숫자로 만들수 있는 모든 permutation들을 return 하여라
	static ArrayList<ArrayList<Integer>> perms = new ArrayList<>();

	public static void permutation(int[] arr, ArrayList<Integer> list) {
		if(list.size() == arr.length) {
			ArrayList<Integer> l = new ArrayList<>();
			for(int i:list) {
				l.add(i);
			}
			perms.add(l);
		}

		for(int i: arr) {
			if(list.indexOf(i) != -1) {
				continue;
			}
			list.add(i);
			permutation(arr,list);
			list.remove(list.size()-1);
		}
	}


}










