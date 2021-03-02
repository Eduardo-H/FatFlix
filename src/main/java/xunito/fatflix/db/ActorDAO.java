package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import xunito.fatflix.entities.Actor;

public class ActorDAO implements InterfaceDAO<Actor> {

	@Override
	public void persist(Actor t) {
		EntityManager em = ConnDB.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			Actor original = get(t.getId());
			em.getTransaction().begin();
			
			original.setName(t.getName());
			original.setBirthDate(t.getBirthDate());
			original.setNationality(t.getNationality());
			original.setSex(t.getSex());
			original.setHeight(t.getHeight());
			em.getTransaction().commit();
		}
	}

	@Override
	public void remove(Actor t) {
		EntityManager em = ConnDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public Actor get(Object pk) {
		return ConnDB.getEntityManager().find(Actor.class, pk);
	}

	@Override
	public List<Actor> getAll() {
		return ConnDB.getEntityManager().createQuery("SELECT a FROM Actor a", Actor.class).getResultList();
	}

}
