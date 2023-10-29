package newCoding0423;
//조합으로구현1
class T5_makePrime3 {

    static int[] nums = {1,2,7,6,4};
	static int res;

	public static void main(String[] args) {
		res=0;
		if(3>nums.length || nums.length>50){
	           System.out.println(res);
	            //return res;
	        }

		solution(0,0,0);
		System.out.println("res:"+res);

	}

    public static void solution(int depth, int cnt, int sum) {

    	if(cnt == 3) {
			if(check(sum)) {
				res++;
				System.out.println("sum:"+sum);
			//	return;
			}
			return;
		}

    	if(depth == nums.length) {
    		return;
    	}

		solution(depth+1, cnt+1, sum+nums[depth]);
		solution(depth+1, cnt, sum);

    }


	public static boolean check(int num) {
    	if(num % 2 == 0)return false;

    	for(int i=2;i<num/2;i++) {
    		if(num%i == 0) return false;
    	}
		return true;
	}
}