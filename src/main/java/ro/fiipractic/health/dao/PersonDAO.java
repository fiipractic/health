package ro.fiipractic.health.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import ro.fiipractic.health.domain.Person;
import ro.fiipractic.health.util.HibernateUtil;

public class PersonDAO {
	private Session session;

	/**
	 * Insert a new Person object into the database.
	 * 
	 * @param prs
	 *            the person to be saved.
	 * @return true if the person has been successfully saved, false otherwise.
	 */
	public boolean savePerson(Person prs) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			return session.save(prs) != null;
		} catch (HibernateException e) {
			System.err.println(e);
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public List<Person> getAllPersons() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			String hql = "FROM Person";
			Query query = session.createQuery(hql);
			List<Person> results = query.list();
			return results;
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return null;
	}

	/**
	 * Return a Person from database based on its id.
	 * 
	 * @param id
	 *            the id from the database.
	 * @return the person having the provided id.
	 */
	public Person getPersonByID(long id) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Person prs = null;
		try {
			String hql = "FROM Person where id=" + id;
			Query query = session.createQuery(hql);
			List<Person> results = query.list();
			prs = results.get(0);
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return null;
	}

	/**
	 * Delete a Person
	 * 
	 * @param prs
	 * @return true if the person was successfully removed from the database,
	 *         false otherwise.
	 */
	public boolean deletePerson(Person prs) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.delete(prs);
			return true;
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return false;
	}

	/**
	 * Updates a person to a new state.
	 * 
	 * @param prs
	 *            the new state of the Person object
	 * @return the new state of the Person object
	 */
	public Person updatePerson(Person prs) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {

			return (Person) session.merge(prs);
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return null;
	}
}
