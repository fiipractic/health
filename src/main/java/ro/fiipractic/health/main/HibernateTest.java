package ro.fiipractic.health.main;

import org.hibernate.Session;

import ro.fiipractic.health.domain.Person;
import ro.fiipractic.health.util.HibernateUtil;

public class HibernateTest {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Person person1 = new Person("Vasile", "Popescu");
		person1.setCnp("173753839585");
		Person person2 = new Person("Eugen", "Stoian");
		person2.setCnp("180715168839585");
		Person person3 = new Person("Ion", "Maftei");
		person3.setCnp("16875546555");
		Person person4 = new Person("Smaranda", "Gheorghiu");
		person4.setCnp("273753839585");

		session.save(person1);
		session.save(person2);
		session.save(person3);
		session.save(person4);
		
		session.getTransaction().commit();
		session.close();
	}
}
