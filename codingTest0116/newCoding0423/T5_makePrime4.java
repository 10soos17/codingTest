package newCoding0423;
//조합으로 구현2-최종
class T5_makePrime4 {
    
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

    public static void solution(int start,int cnt, int sum) {

    	if(cnt == 3) {
			if(check(sum)) {
				res++;
				System.out.println("sum:"+sum);
			//	return;
			}
			return;
		}
    	
    	for(int i=start;i<nums.length;i++) {
    		solution(i+1,cnt+1,sum+nums[i]);
    	}
    }
    
	public static boolean check(int num) {
		//if(num == 2)return true;
    	if(num % 2 == 0)return false;

    	for(int i=3;i<(int)num/2;i++) {
    		if(num%i == 0) return false;
    	}
		return true;
	}
}