package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityManager;

import xunito.fatflix.entities.Actor;

public class ActorDAO implements InterfaceDAO<Actor> {

	@Override
	public void persist(Actor t) {
		// TODO Auto-generated method stub
		
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
