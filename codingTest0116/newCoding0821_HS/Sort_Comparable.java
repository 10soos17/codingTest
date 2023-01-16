package newCoding0821_HS;

import java.util.Arrays;

class Person implements Comparable<Person>{
	
	String name;
	int age, money;
	
	public Person(String name, int age, int money) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return o.money - money;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", "
				+ "age=" + age + ", "
				+ "money=" + money + "]";
	}
}

class Sort_Comparable {

	public static void main(String[] args) {

		Person p = new Person("shinsoo",5,1000);
		Person p2 = new Person("parkhansaem",71,1000000000);
		Person p3 = new Person("chichi",8,30);
		
		Person[] arr = new Person[3];
		
		arr[0] = p;
		arr[1] = p2;
		arr[2] = p3;
		
		Arrays.sort(arr);
		
		for(Person pp : arr) System.out.println(pp);
		
	}
}