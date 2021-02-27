package xunito.fatflix.entities;

public class Actor extends Person {
	private float height;
	
	public Actor(String name, String birthDate, String nationality, String sex, float height) {
		super(name, birthDate, nationality, sex);
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
}
