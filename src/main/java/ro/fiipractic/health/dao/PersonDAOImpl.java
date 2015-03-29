package ro.fiipractic.health.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.fiipractic.health.domain.Person;

@Repository(value = "personDao")
@Transactional
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Person> findAll() {
		List<Person> prs = new ArrayList<Person>();
		Person person1 = new Person("Vasile", "Popescu");
		person1.setCnp("173753839585");
		prs.add(person1);
		return prs;
	}

	public Person save(Person contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		return contact;
	}

	public void delete(Person contact) {
		sessionFactory.getCurrentSession().delete(contact);
	}

	public Person findById(long id) {
		return (Person) sessionFactory.getCurrentSession()
				.createQuery("FROM Person where id =" + id).list().get(0);
	}

	/**
	 * Ar putea exista mai multe persoane cu acelasi prenume
	 * 
	 * @param firstName
	 *            prenumele persoanei cautate
	 * @return lista cu persoane ce au prenumele egal cu <b>firstName</b>
	 */
	public List<Person> findByFirstName(String firstName) {
		String queryString = "FROM Person where firstname = :firstName";
		Query query = sessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("firstName", firstName);
		List<Person> results = query.list();
		return results;

	}

}
