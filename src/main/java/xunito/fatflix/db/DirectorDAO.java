package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityManager;

import xunito.fatflix.entities.Actor;
import xunito.fatflix.entities.Director;

public class DirectorDAO implements InterfaceDAO<Director> {

	@Override
	public void persist(Director t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Director t) {
		EntityManager em = ConnDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public Director get(Object pk) {
		return ConnDB.getEntityManager().find(Director.class, pk);
	}

	@Override
	public List<Director> getAll() {
		return ConnDB.getEntityManager().createQuery("SELECT d FROM Director d", Director.class).getResultList();
	}

}
