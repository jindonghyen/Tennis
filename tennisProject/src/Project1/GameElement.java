package Project1;

// 이름, 성별, 단/복식을 선언한 슈퍼클래스

public abstract class GameElement {

	private String [] name;
	private int gender;
	private int soloDuo;
	
	public GameElement() {
		
	}
	
	public GameElement(String[] name, int gender, int soloDuo) {
		
		this.name = name;
		this.gender = gender;
		this.soloDuo = soloDuo;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getSoloDuo() {
		return soloDuo;
	}

	public void setSoloDuo(int soloDuo) {
		this.soloDuo = soloDuo;
	}
	
}
