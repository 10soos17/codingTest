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

//조합 - 가장 큰 두 수의 합 구하기
//https://www.youtube.com/watch?v=CDLBg6wbhUQ&list=PL6YHvWRMtz7CbOmh5Id4DERE5gyQC50XS&index=4
public class Combination55 {
	static int n = 4;
	static int[] arr = { 1, 2, 3, 4 };

	public static void main(String[] args) {

		solve(0, 0, 0);

	}

	public static int solve(int pos, int cnt, int val) {

		if (cnt == 2) {
			return val;
		}
		if (pos == n) {
			return -1;
		}
		int ret = 0;
		ret = Math.max(ret, solve(pos, cnt + 1, val + arr[pos]));
		ret = Math.max(ret, solve(pos + 1, cnt, val));

		return ret;
	}
}
