package xunito.fatflix.entities;

public abstract class Person {
	private int id;
	private String name;
	private String birthDate;
	private String nationality;
	private String sex;
	
	public Person(String name, String birthDate, String nationality, String sex) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
