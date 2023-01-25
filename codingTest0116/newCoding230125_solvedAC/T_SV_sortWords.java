package newCoding230125_solvedAC;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//https://www.acmicpc.net/problem/1181

public class T_SV_sortWords {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		String [] map = new String[N];
		for(int i=0;i<N;i++) map[i] = br.readLine();
	

		Arrays.sort(map, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length())return s1.compareTo(s2); //사전순
				return s1.length() - s2.length(); // 길이 짧은것 
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(map[0]).append("\n");
		for(int i=1;i<N;i++) {
			if(map[i].equals(map[i-1])) continue;
			sb.append(map[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
