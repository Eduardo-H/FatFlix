package xunito.fatflix.entities;

import javax.persistence.Entity;

@Entity
public class Director extends Person {

	public Director() {
		super();
	}
	
	public Director(String name, String birthDate, String nationality, String sex) {
		super(name, birthDate, nationality, sex);
	}

	public Director(int id, String name, String birthDate, String nationality, String sex) {
		super(id, name, birthDate, nationality, sex);
	}
	
}
