package coding02_package;

//기본 클래스 +생성자 + getter, setter + toString
public class Person{
	
	public String name;
	public int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return "name: "+name+"age: "+age;
		
	}
}