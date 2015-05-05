package ro.fiipractic.health.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.fiipractic.health.domain.Person;


public class PersonDAOTest {

	@Autowired
	PersonDAO prsDao;

	@Ignore
	@Test
	public void testFindAll() {
		int number = prsDao.findAll().size();
		assertEquals(
				"The number of returned persons doesn't match the expected value",
				0, number);
	}
	@Ignore
	@Test
	public void testSave() {
		Person catalin = new Person("Catalin", "Ciobanu");
		catalin.setCnp("173753839585");
		assertNotNull("The person was not save. Please save Catalin.",
				prsDao.save(catalin));
	}
	@Ignore
	@Test
	public void testFindById() {
		assertNotNull("Cannot find by id = 1", prsDao.findById(1));
	}
	@Ignore
	@Test
	public void testFindByFirstName() {
		Person c = prsDao.findByFirstName("Catalin").get(0);
		assertNotNull("Cannot find by firstName = Catalin", c);
	}
	@Ignore
	@Test
	public void testDelete() {
		List<Person> prss = prsDao.findByFirstName("Catalin");
		Person c = prss.get(0);

		assertEquals(
				"Should have found only one person with the firstName = Catalin",
				1, prss.size());
		assertNotNull("Can't find Catalin, where is Catalin ?", c);

		prsDao.delete(c);

		int numberOfPersons = prsDao.findAll().size();
		assertEquals("Unsuccessfull delete", 0, numberOfPersons);
	}

}
