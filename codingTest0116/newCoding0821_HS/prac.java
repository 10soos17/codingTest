package newCoding0821_HS;

public class prac {
	
	static int target = 0;
	static int[] arr1 = {1,1,1,1,1};
	static int len1 = arr1.length;
	static int answer = 0;
	
	static void subset(int dep, int sum) {
		
		if(dep == len) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		
		subset(dep+1, sum+arr[dep]);
		subset(dep+1, sum-arr[dep]);
	}
	
	static int[] arr = {1,2,3,4};
	static int[] tmp;
	static int len = arr.length;
	static boolean[] visited;
	static int cnt;
	
	static void subset2(int dep) {
		if(dep == 3) {
			for(int i=0;i<3;i++) System.out.println("," +(visited[i] ? tmp[i] : "X"));
			return;
		}
		
		visited[dep] = true;
		tmp[dep] = arr[dep];
		subset2(dep+1);
		
		visited[dep] = false;
		tmp[dep] = arr[dep];
		subset2(dep+1);
	}
	public static void main(String[] args) {
		visited = new boolean[len];
		tmp = new int[len];
		
		
	}
	

}