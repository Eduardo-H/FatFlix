package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityManager;

import xunito.fatflix.entities.Movie;
import xunito.fatflix.entities.Producer;

public class ProducerDAO implements InterfaceDAO<Producer> {

	@Override
	public void persist(Producer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Producer t) {
		EntityManager em = ConnDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public Producer get(Object pk) {
		return ConnDB.getEntityManager().find(Producer.class, pk);
	}

	@Override
	public List<Producer> getAll() {
		return ConnDB.getEntityManager().createQuery("SELECT p FROM Producer p", Producer.class).getResultList();
	}

}
