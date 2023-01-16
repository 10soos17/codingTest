package newCoding0423;

import java.util.ArrayList;

public class Parsing {

	public static void main(String[] args) {
		String[] data= {"com.kakaopay.mone+C3:C127yball.sc.scgo8000.jar",
			"com.kakaopay.moneyball.sc.scgo9000.jar",
			"boss-servlet-api_4.0_spec-1.0.0.Final.jar",
			"jboss-transaction-api_1.2_spec-1.1.1.Final.jar",
			"mysql-connector-java-5.1.48.jar",
			"nexcore-framework-batch-7.2.0.jar",
			"nexcore-framework-batch-nodemanager-7.2.0.jar",
			"nexcore-framework-centercut-7.2.0.jar",
			"nexcore-framework-custom-batch-1.0.jar",
			"nexcore-framework-supports-7.2.0.jar",
			"ojdbc8.jar",
			"ant-1.7.0.jar",
			"ant-contrib-1.0b3.jar",
			"ant-launcher-1.7.0.jar",
			"commons-httpclient-3.1.jar",
			"jakarta.mail-api-1.6.4.jar",
			"javaee-api-5.jar",
			"nexcore-framework-build-antsupport-7.2.0.jar",
			"idcard-decrypt-1.0-SNAPSHOT.jar",
			"idcard-encrypt-1.0-SNAPSHOT.jar"};
		
		
		//+엑셀로 불러와서 읽기 
		
		String[] words = {"SNAPSHOT"};	//db 객체
		ArrayList<String> appendix = addAppendix(words);
		
		String[] answer = parsing(data, appendix);
		
		//+엑셀로 저장하기 

	}
	public static ArrayList<String> addAppendix(String[] words){
		ArrayList<String> appendix = new ArrayList<>();
		for(String s : words) {
			appendix.add(s);
		}
		
		return appendix;
	}
	public static String[] parsing(String[] data, ArrayList<String> appendix) {
		
		String[] version = new String[data.length];
		
		int i=0;
		for(String s : data) {
			//split "-",
			//마지막인덱스 replace(".jar", "")
			//length<2(버전없는지체크 
			//없으면 null값
			//있으면 ->숫자체크 - 있으면 / 없으면 그전까지?
			
			String[] list = s.split("-");
			
			String check = list[list.length-1].replace(".jar","");
			
			version[i] = list.length < 2 ? null : appendix.contains(check) ? list[list.length-2]+"-"+check : check;
			System.out.println(s+":"+i+"_________"+version[i]);
			i++;
			
		}
		
		return version;
	}

}
