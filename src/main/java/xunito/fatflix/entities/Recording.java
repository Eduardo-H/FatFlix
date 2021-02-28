package xunito.fatflix.entities;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Recording {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto increment
	private int id;
	
	private String title;
	private int releaseYear;
	
	private ArrayList<Director> directors;
	private ArrayList<Actor> actors;
	private ArrayList<Producer> producers;
	
	public Recording(String title, int releaseYear) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		directors = new ArrayList<Director>();
		actors = new ArrayList<Actor>();
		producers = new ArrayList<Producer>();
	}
	
	public Recording(String title, int releaseYear, ArrayList<Director> directors, ArrayList<Producer> producers, ArrayList<Actor> actors) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.directors = directors;
		this.producers = producers;
		this.actors = actors;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public ArrayList<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(ArrayList<Director> directors) {
		this.directors = directors;
	}

	public ArrayList<Actor> getActors() {
		return actors;
	}

	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}

	public ArrayList<Producer> getProducers() {
		return producers;
	}

	public void setProducers(ArrayList<Producer> producers) {
		this.producers = producers;
	}
	
}
