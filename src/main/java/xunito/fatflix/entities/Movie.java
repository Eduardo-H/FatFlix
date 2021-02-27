package xunito.fatflix.entities;

import javax.persistence.Entity;

@Entity
public class Movie extends Recording {
	private String length;
	
	public Movie(String title, int releaseYear, String lenght) {
		super(title, releaseYear);
		this.length = lenght;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
}
