package xunito.fatflix.entities;

import javax.persistence.Entity;

@Entity
public class Director extends Person {

	public Director(String name, String birthDate, String nationality, String sex) {
		super(name, birthDate, nationality, sex);
	}

}
