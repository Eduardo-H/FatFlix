package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityManager;

import xunito.fatflix.entities.Producer;
import xunito.fatflix.entities.TVShow;

public class TVShowDAO implements InterfaceDAO<TVShow> {

	@Override
	public void persist(TVShow t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(TVShow t) {
		EntityManager em = ConnDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public TVShow get(Object pk) {
		return ConnDB.getEntityManager().find(TVShow.class, pk);
	}

	@Override
	public List<TVShow> getAll() {
		return ConnDB.getEntityManager().createQuery("SELECT t FROM TVShow t", TVShow.class).getResultList();
	}

}
