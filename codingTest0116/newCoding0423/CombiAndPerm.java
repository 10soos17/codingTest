package newCoding0423;

import java.util.Arrays;

public class CombiAndPerm {

	static int[] arr = { 1, 2, 3, 4, 5 };

//중복 불허용이면-> 재귀호출시 start 인덱스 +1
//조합
//순열 ->visted 로직추가


//기본적으로 static 배열로 static int[] arr = { 1, 2, 3, 4, 5 };선언했다고 생각하자.
//
//1 조합
//1,2,3,4,5 중에서 3개를 뽑는 것이다.  1,2,3과 1,3,2 가 똑같은 것으로 치는 것이다. 1,1,2는 조합으로 안친다.
// -> 총 개수 5개에서 3개를 뽑는 것이다.(순서는 상관없음.)

//	파라미터 정의
//	r : 뽑고자 하는 개수
//	temp : r개를 뽑는 결과값을 저장해놓는 배열
//	current : 현재 개수를 저장해 놓는 값
//	start : 그다음 반복문을 시작하는 값
//	코드 설명 : 조합을 재귀로 구현을 하였다. current 값을 늘려주면서 r값에 도달하면 temp를 출력하게 했다.
//	start 값이 i + 1 인 이유는 나왔던 값이 또다시 반복되면 안 되기 때문.
//	(예를 들어 1이 배열에 들어갔는데 1이 또 배열에 들어가게 되면 조합이 성립이 안되기 때문.)

	public static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}


//2 중복 조합
//1,2,3,4,5 중에서 중복을 포함해서 3개를 뽑는 것이다. 조합에서 1,1,2 같은 중복되는 것도 중복 조합으로 친다.
//-> 총 개수 5개에서 중복을 포함해서 3개를 뽑는 것이다.

//파라미터 정의
//
//r : 뽑고자 하는 개수
//temp : r개를 뽑는 결과값을 저장해놓는 배열
//current : 현재 개수를 저장해 놓는 값
//start : 그다음 반복문을 시작하는 값
//코드 설명 : 재귀로 구현하였다. current 값을 늘려주면서 r값에 도달하면 temp를 출력하게 했다.
//	start 값이 i 인 이유는 나왔던 값이 또 나와도 되기 때문.
	public static void makeOverlabCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeOverlabCombination(r, temp, current + 1, i);
			}
		}
	}



//3순열
//1,2,3,4,5 중에서 순서를 생각해서 3개를 뽑는 것이다. 1,2,3과 1,3,2를 다른 것으로 친다.
//-> 총 개수 5개에서 3개를 순서를 고려해서 뽑는 것이다. ( 3개를 뽑아서 순서를 다르게 정렬하는 것으로도 볼 수 있다.)
//
//파라미터 정의
//
//r : 뽑고자 하는 개수
//temp : r개를 뽑는 결과값을 저장해놓는 배열
//current : 현재 개수를 저장해 놓는 값
//visited : 방문 여부를 확인하는 배열
//코드 설명 : 재귀로 구현하였다. 방문 여부를 구하는 visited로 방문 여부를 체크해서 방문했다면 배열에 넣지 않고
//	방문하지 않았다면 배열에 넣어서 순열을 구현했다.

	public static void makePermutation(int r, int[] temp, int current, boolean[] visited) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = arr[i];
					makePermutation(r, temp, current + 1, visited);
					visited[i] = false;
				}
			}
		}
	}

//중복 순열
//1,2,3,4,5 중에서 순서를 고려해서, 중복을 포함한 3개를 뽑는 것이다. 1,2,1과 2,1,1을 다른 것으로 친다.
//-> 총 개수 5개에서 중복 포함, 순서를 고려해서 3개를 뽑는 것이다.
//
//파라미터 정의
//
//r : 뽑고자 하는 개수
//temp : r개를 뽑는 결과값을 저장해놓는 배열
//current : 현재 개수를 저장해 놓는 값
//visited : 방문 여부를 확인하는 배열
//코드 설명 : 재귀로 구현하였다. 기존 순열의 코드에서 방문 여부만 제외해서 뽑게 되면 중복을 포함할 수 있다.

	public static void makeOverlabPermutation(int r, int[] temp, int current) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int element : arr) {
				temp[current] = element;
				makeOverlabPermutation(r, temp, current + 1);
			}
		}
	}

}
