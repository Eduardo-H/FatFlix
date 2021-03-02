package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import xunito.fatflix.entities.Producer;

public class ProducerDAO implements InterfaceDAO<Producer> {

	@Override
	public void persist(Producer t) {
		EntityManager em = ConnDB.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			Producer original = get(t.getId());
			em.getTransaction().begin();
			
			original.setName(t.getName());
			original.setFoundation(t.getFoundation());
			em.getTransaction().commit();
		}
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
