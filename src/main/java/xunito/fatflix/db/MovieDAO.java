package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityManager;

import xunito.fatflix.entities.Director;
import xunito.fatflix.entities.Movie;

public class MovieDAO implements InterfaceDAO<Movie> {

	@Override
	public void persist(Movie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Movie t) {
		EntityManager em = ConnDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public Movie get(Object pk) {
		return ConnDB.getEntityManager().find(Movie.class, pk);
	}

	@Override
	public List<Movie> getAll() {
		return ConnDB.getEntityManager().createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
	}

}
