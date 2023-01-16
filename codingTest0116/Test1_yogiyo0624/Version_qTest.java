package Test1_yogiyo0624;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version_qTest {
	// ... write your unit tests here ...

	public static void main(String[] args) {
		int n = 0;

		exampleTest();
		exampleTest2();


	}

	// ... write your unit tests here ...

	public static void exampleTest() {
		Version version = new Version("3.8.0");
		version.isSnapshot();
	}

	public static void exampleTest2() {
		Version version = new Version("3.8.0-SNAPSHOT");
		version.isSnapshot();
	}

	// expected error messages:

	static final String errorVersionMustNotBeNull = "'version' must not be null!";
	static final String errorOtherMustNotBeNull = "'other' must not be null!";
	static final String errorVersionMustMatchPattern = "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

	public static class Version implements Comparable<Version> {

		String version;
		boolean snapshot;
		
		public Version() {
			IllegalArgumentException e = new IllegalArgumentException(errorVersionMustNotBeNull);
			throw e;
		}

		public Version(String version) {
			
			// regular expression check
			String reg = "\\d+(\\.\\d+){0,2}(-SNAPSHOT)?";//"^[0-9][.]{3}[-SNAPSHOT]?";//"\d+(\.\d+){0,2}(-SNAPSHOT)?";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(version);
			if (!m.find()) {
				IllegalArgumentException e = new IllegalArgumentException(errorVersionMustMatchPattern);
				throw e;
			}

			this.version = version;
			
			System.out.println(this.version);

		}

		boolean isSnapshot() {
			this.snapshot=this.version.endsWith("-SNAPSHOT");
			return this.snapshot;
		};
		
		public int compareCheck() {
			String trim=this.version;
			if(isSnapshot()){
				trim = this.version.replace("-SNAPSHOT","");
			}
			trim = trim.replace(".", "");
			System.out.println(trim);
			int intVersion = Integer.parseInt(trim);
			
			return intVersion;
			
		}

		@Override
		public int compareTo(Version o) {
			if (o == null) {
				IllegalArgumentException e = new IllegalArgumentException(errorOtherMustNotBeNull);
				throw e;
			}
			int n = this.compareCheck();
			//System.out.println(n);
			int m = o.compareCheck();
			System.out.println(m);
			if(n>m) {
				return 1;
			}else if(n<m) {
				return -1;
			}else {
				if(this.isSnapshot() && !o.isSnapshot()) return -1;
				if(!this.isSnapshot() && o.isSnapshot()) return 1;
			}
			return 0;
		}
	}
}
