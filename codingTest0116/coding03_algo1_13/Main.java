package coding03_algo1_13;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student("one", "1");
		Student st2 = new Student("two", "2");
		Student st3 = new Student("three", "3");
		
		ArrayList<Student> list = new ArrayList<Student>();

		
		list.add(st1);
		list.add(st2);
		list.add(st3);
		
		for(Student stu : list) {
			System.out.println(stu.getName());
			System.out.println(stu.getNo());
		}
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("입력 y, 종료 n");
			
			String input = scanner.next();
			boolean flag = false;
		
			if(input.equals("y")) {
				System.out.println("start searching");
				String name = scanner.next();
				
				for(Student stu : list) {
					if(stu.getName().equals(name)) {
						System.out.println("student no: " + stu.getNo());
						flag = true;
					}
				}
				
				if(!flag) {
					System.out.println("not exist");
				}
				
			}else if(input.equals("n")) {
				break;
			}
			
			
		}
		System.out.println("exit");
		
	}

}
