package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import xunito.fatflix.entities.Movie;

public class MovieDAO implements InterfaceDAO<Movie> {

	@Override
	public void persist(Movie t) {
		EntityManager em = ConnDB.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			Movie original = get(t.getId());
			em.getTransaction().begin();
			
			original.setTitle(t.getTitle());
			original.setReleaseYear(t.getReleaseYear());
			original.setLength(t.getLength());
			original.setDirectors(t.getDirectors());
			original.setActors(t.getActors());
			original.setProducers(t.getProducers());
			em.getTransaction().commit();
		}
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
