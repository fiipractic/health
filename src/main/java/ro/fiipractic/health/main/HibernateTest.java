package ro.fiipractic.health.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.fiipractic.health.dao.PersonDAO;
import ro.fiipractic.health.domain.Person;

public class HibernateTest {
	public static void main(String[] args) {

		// load spring context
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"health-app-spring-context.xml");
		PersonDAO personDao = ctx.getBean("personDao", PersonDAO.class);

		Person person1 = new Person("Vasile", "Popescu");
		person1.setCnp("173753839585");
		Person person2 = new Person("Eugen", "Stoian");
		person2.setCnp("180715168839585");
		Person person3 = new Person("Ion", "Maftei");
		person3.setCnp("16875546555");
		Person person4 = new Person("Smaranda", "Gheorghiu");
		person4.setCnp("273753839585");

		personDao.save(person1);
		personDao.save(person2);
		personDao.save(person3);
		personDao.save(person4);

		List<Person> persons = personDao.findAll();
		System.out.println("Found " + persons.size() + " persons in database.");
	}
}
