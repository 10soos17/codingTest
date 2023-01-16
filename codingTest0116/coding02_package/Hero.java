package coding02_package;

//상속 + 클래스
public class Hero extends Character{
	
	public Hero(String name) {
		setName(name);
	}
	
	private boolean isFlying;
	
	public boolean isFlying() {
		return isFlying;
	}
	
	public void setFlying(boolean flying) {
		isFlying = flying;
	}
	
	@Override
	public void attack(Hero hero){
		System.out.println(this.getName() + "은" + hero.getName() + "과 싸움을 했다.");
		}
}