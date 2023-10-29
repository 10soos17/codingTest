package newCoding0423;

class T3_photo2 {

    static String[] name = { "A", "C", "F", "J", "M", "N", "R", "T" };
	static boolean[] visited = new boolean[8];
	static int res;
    static String[] datas;

    public int solution(int n, String[] data) {
        if(1>n || n>100){
           System.out.println(res);
            return res;
        }
       res=0;
        datas = data.clone();
        com("");

        return res;
    }

   public void com(String answer) {

		if(answer.length() ==8) {
			if(check(answer)) {
				res++;
                return;
			}

		}

		for(int i=0; i<8;i++) {
			if(!visited[i]) {
				visited[i]=true;
				String text = answer+name[i];
				com(text);
				visited[i]=false;
			}
		}
	}

	public boolean check(String answer) {

		for (String element : datas) {
	            int start = answer.indexOf(element.charAt(0));
                int end = answer.indexOf(element.charAt(2));

                if(element.charAt(3) =='=' && Math.abs(start-end)-1!=element.charAt(4)-'0'){
                    return false;
                }else if(element.charAt(3) =='<' && Math.abs(start-end)-1>=element.charAt(4)-'0'){
                    return false;
                }else if(element.charAt(3) =='>' && Math.abs(start-end)-1<=element.charAt(4)-'0'){
                    return false;
                }
		}
		return true;
	}
}