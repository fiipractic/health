package ro.fiipractic.health.main;

import java.util.List;

import ro.fiipractic.health.dao.PersonDAO;
import ro.fiipractic.health.domain.Person;

public class HibernateTest {
	private static PersonDAO prsDAO;

	public static void main(String[] args) {

		prsDAO = new PersonDAO();
		insertMyPersons();
		printFirstNames();
		updateFirstPerson();
		deletePerson();

	}

	private static void insertMyPersons() {

		Person person1 = new Person("Vasile", "Popescu");
		person1.setCnp("173753839585");
		Person person2 = new Person("Eugen", "Stoian");
		person2.setCnp("180715168839585");
		Person person3 = new Person("Ion", "Maftei");
		person3.setCnp("16875546555");
		Person person4 = new Person("Smaranda", "Gheorghiu");
		person4.setCnp("273753839585");

		if (prsDAO.savePerson(person1)) {
			System.out.println("Person with cnp: " + person1.getCnp()
					+ " successfully saved!");
		}

		if (prsDAO.savePerson(person2)) {
			System.out.println("Person with cnp: " + person2.getCnp()
					+ " successfully saved!");
		}

		if (prsDAO.savePerson(person3)) {
			System.out.println("Person with cnp: " + person3.getCnp()
					+ " successfully saved!");
		}

		if (prsDAO.savePerson(person4)) {
			System.out.println("Person with cnp: " + person4.getCnp()
					+ " successfully saved!");
		}
	}

	private static void printFirstNames() {
		List<Person> persons = prsDAO.getAllPersons();
		for (Person prs : persons) {
			System.out.println("The Person with id " + prs.getId() + " is: "
					+ prs.getFirstName());
		}
	}

	private static void updateFirstPerson() {
		Person prs = prsDAO.getAllPersons().get(0);
		prs.setFirstName("UpdatedFirstName");
		prsDAO.updatePerson(prs);
		System.out.println("Our persons after update:");
		printFirstNames();
	}

	private static void deletePerson() {
		Person prs = null;
		prs = prsDAO.getAllPersons().get(0);
		System.out.println("Deleting person: " + prs.getFirstName());
		prsDAO.deletePerson(prs);
		printFirstNames();
	}
}
