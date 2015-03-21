package ro.fiipractic.health.main;

import ro.fiipractic.health.dao.PersonDAO;
import ro.fiipractic.health.domain.Person;

public class HibernateTest {
	private static PersonDAO prsDAO;

	public static void main(String[] args) {

		prsDAO = new PersonDAO();
		insertMyPersons();
		printFirstNames();

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
		Person prs = null;
		prs = prsDAO.getPersonByID(1);
		System.out.println("The Person with id 1 is: "+ prs.getFirstName());
		prs = prsDAO.getPersonByID(2);
		System.out.println("The Person with id 2 is: "+ prs.getFirstName());
		prs = prsDAO.getPersonByID(3);
		System.out.println("The Person with id 3 is: "+ prs.getFirstName());
		prs = prsDAO.getPersonByID(4);
		System.out.println("The Person with id 4 is: "+ prs.getFirstName());
	}
}
