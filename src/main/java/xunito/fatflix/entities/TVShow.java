package xunito.fatflix.entities;

public class TVShow extends Recording {
	private int seasons;
	
	public TVShow(String title, int releaseYear, int seasons) {
		super(title, releaseYear);
		this.seasons = seasons;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}
	
}
