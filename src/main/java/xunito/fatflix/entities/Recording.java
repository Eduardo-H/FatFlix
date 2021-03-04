package xunito.fatflix.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Recording {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto increment
	private int id;
	
	private String title;
	private int releaseYear;
	
	@ManyToMany
	private List<Director> directors;
	@ManyToMany
	private List<Actor> actors;
	@ManyToMany
	private List<Producer> producers;
	
	
	public Recording() {
		
	}
	
	public Recording(String title, int releaseYear) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		directors = new ArrayList<Director>();
		actors = new ArrayList<Actor>();
		producers = new ArrayList<Producer>();
	}
	
	public Recording(String title, int releaseYear, List<Director> directors, List<Producer> producers, List<Actor> actors) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.directors = directors;
		this.producers = producers;
		this.actors = actors;
	}
	
	public Recording(int id, String title, int releaseYear, List<Director> directors, List<Producer> producers, 
			List<Actor> actors) {
		super();
		this.id = id;
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
	
	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}
	
}
