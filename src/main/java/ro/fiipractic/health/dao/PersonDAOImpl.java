package ro.fiipractic.health.dao;

import java.util.List;

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
		return sessionFactory.getCurrentSession().createQuery("from Person p")
				.list();
	}

	public Person save(Person contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		return contact;
	}

	public void delete(Person contact) {
		sessionFactory.getCurrentSession().delete(contact);
	}

}
