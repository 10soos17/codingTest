package newCoding0821_HS;

public class Subset_01 {

	static int target =4 ;
	static int[] arr= {1,1,1,1};
	static boolean[] visited;
	static int len=arr.length;
	static int answer = 0;
	
	
	static void subset(int dep, int sum) {
		
		if(dep==len) {
			if(sum==target) {
				answer++;
			}
			return;
		}
		
		
		subset(dep+1,sum+arr[dep]);
		subset(dep+1,sum-arr[dep]);
		
	}
	
	

	public static void main(String[] args) {
		
	//	visited = new boolean[len];
		
		subset(0,0);
		
		System.out.println(answer);

	}

}