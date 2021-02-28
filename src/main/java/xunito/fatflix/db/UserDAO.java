package xunito.fatflix.db;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import xunito.fatflix.entities.User;

public class UserDAO implements InterfaceDAO<User> {

	@Override
	public void persist(User t) {
		EntityManager em = ConnDB.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			User original = get(t.getUsername());
			em.getTransaction().begin();
			original.setPassword(t.getPassword());
			em.getTransaction().commit();
		}
	}

	@Override
	public void remove(User t) {
		EntityManager em = ConnDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public User get(Object pk) {
		return ConnDB.getEntityManager().find(User.class, pk);
	}

	@Override
	public List<User> getAll() {
		return ConnDB.getEntityManager().createQuery("SELECT u FROM User u", User.class).getResultList();
	}
	
}
