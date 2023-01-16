package coding01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Character Stream: 문자기반(2Byte 단위) 스트림, Reader/Writer
//: 사람이 이해할 수 있는 문자로 구성된 Stream(text file)

//Byte Stream: Byte단위(1Byte) 스트림, InputStream/OutputStream
//: 사람이 보아서 알 수 없지만, 프로그램에서 Binary Data로 구성된 Stream(Binary file)
public class ClassRehearse_fileIO {

	public static void main(String[] args) {

//=================== String <-> Byte=========================================================
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		
		String str11 = new String(bytes);
		System.out.println(str11);

		String str22 = new String(bytes,6,4);
		System.out.println(str22);

//===================File 읽기1=========================================================
		try {
			FileReader fr = new FileReader("text.txt");//컴파일 에러 발생 try~catch
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			do {
				str = br.readLine();//컴파일 에러 발생 try~catch
				System.out.println(str);
			
			}while(!(str == null));
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다. 위치 확인");
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
		System.out.println("Done");
		
//===================파일 읽기2 =========================================================
		FileReader fr = null;
		try {
			fr = new FileReader("../../maven.txt");
			int i;
			while (true) {
				i = fr.read(); // a=97
				if (i == -1) // -1: end of file
					break;
				char ch = (char) i; // a
				System.out.println(ch);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 없습니다..");
		} catch (IOException e) {
			System.out.println("IO에 문제 있습니다 .");
		}
		try {
			fr.close();
		} catch (IOException e) {

		}

		System.out.println("종료");
//===================파일 쓰기 =========================================================
		FileWriter fw = null;
		try {
			fw = new FileWriter("../../maven.txt");
			char[] arr = { 'a', 'b', 'c', 'd' };
			// 반복문장을 통한 arr 출력
			for (char c : arr) {
				System.out.println(c);
				fw.write(c);
			}
		} catch (IOException e) {
			System.out.println("파일을 출력할 수 없습니다.");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {

			}
		}
		System.out.println("종료");
		
//===================FileInputStream 읽기 1 =========================================================
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("../../output.dat");
			int i;
			while (true) {
				try {
					i = fi.read();
					byte b = (byte) i;
					if (b == -1)
						break;
					System.out.print(b);
				} catch (IOException e) {
					System.out.println("파일을 읽을 수가 없습니다.");
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수가 없습니다.");
		} finally {
			try {
				fi.close();
			} catch (IOException e) {

			}
		}
		System.out.println("종료");
		
		//===================FileInputStream 읽기 2 =========================================================		
		FileInputStream fi1 = null;
		try {
			fi1 = new FileInputStream(args[0]);
			byte arr[] = new byte[16];

			while (true) {
				try {
					int data = fi1.read(arr);

					if (data < 0)
						break;
					for (int i = 0; i < data; i++)
						System.out.println(arr[i]);
				} catch (IOException e) {
					System.out.println("파일을 읽을 수가 없습니다.");
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수가 없습니다.");
		} finally {
			try {
				fi1.close();
			} catch (IOException e) {

			}
		}
		System.out.println("종료");
		
//===================FileOutputStream 쓰기 =========================================================		
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("../../output.dat");
			byte[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

			for (int i = 0; i < arr.length; i++) {
				try {
					fo.write(arr[i]);
				} catch (IOException e) {
					System.out.println("error");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수가 없습니다.");
		} finally {
			try {
				fo.close();
			} catch (IOException e) {

			}
		}
		
	}
	
	
}
