package xunito.fatflix.entities;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Movie extends Recording {
	private String length;
	
	
	public Movie() {
		super();
	}
	
	public Movie(String title, int releaseYear, String length) {
		super(title, releaseYear);
		this.length = length;
	}

	public Movie(String title, int releaseYear, String length, List<Director> directors, List<Actor> actors,
			List<Producer> producers) {
		super(title, releaseYear, directors, producers, actors);
		this.length = length;
	}
	
	public Movie(int id, String title, int releaseYear, String length, List<Director> directors, 
			List<Actor> actors, List<Producer> producers) {
		super(id, title, releaseYear, directors, producers, actors);
		this.length = length;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
}
