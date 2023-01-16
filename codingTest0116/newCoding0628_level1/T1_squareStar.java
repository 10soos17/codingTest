package newCoding0628_level1;


class T1_squareStar {
//	두 개의 정수 n과 m이 주어집니다.
//	별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력
//	5 3
//	출력
//
//	*****
//	*****
//	*****
	public static void main(String[] args) {
		int n=5;
		int m=3;
		solution(n,m);
		//System.out.println("res:"+res);
	}

	public static void solution(int n, int m) {
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
}