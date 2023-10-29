package coding07_algo41_50;

//[완전탐색 (Exhaustive search, Brute force)]
//모든 경우의 수를 시도해보는 방법
//상대적으로 구현이 간단, 해가 존재한다면 항상 찾게 됨
//경우의 수에 따라 실행 시간이 비례
//입력 값의 범위가 작은 경우에 유용

//ex.
//1.순차탐색(sequential search) : 검색(O(n))

//경우의 수
//순열(permutation) : 선택 순서가 결과에 영향을 미치는 경우
//조합(combination) : 선택 순서가 결과에 영향을 주지 않는 경우


//순열 - 가장 큰 두 자리 수 구하기
public class Permutation44 {
	static int n = 4;
	static int[] arr = {1,2,3,4};

	public static void main(String[] args) {


		solve(0,0,0);

	}
	public static int solve(int cnt, int used, int val) {

		if(cnt == 2) {
			return val;
		}
		int ret=0;
		for(int i=0;i<n;i++) {
			if((used & 1 << i) !=0) {
				continue;
			}
			ret = Math.max(ret, solve(cnt+1, used | 1 << i, val * 10 + arr[i]));
		}


		return ret;
	}
}
