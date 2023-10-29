package newCoding0821_HS;

public class Subset_02 {

	static int[] arr = { 1, 2, 3, 4 };
	static int len = arr.length;
	static int[] tmp;
	static boolean[] visited;
	static int cnt;

	static void subset(int dep) {


		if(dep==3) {
			for(int i=0;i<len-1;i++)
				System.out.print(", " + (visited[i] ? tmp[i] : "X"));

			System.out.println();
			return;
		}


		visited[dep] = true;
		tmp[dep] = arr[dep];
		subset(dep+1);

		visited[dep] = false;
		tmp[dep] = arr[dep];
		subset(dep+1);



	}


	public static void main(String[] args) {
		tmp = new int[arr.length-1];
		visited = new boolean[arr.length-1];
		subset(0);
		System.out.println("총 개수 : " + cnt);

	}

}