package ro.fiipractic.health.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:health-app-test-spring-context.xml")
public class PersonDAOTest {

	@Autowired
	PersonDAO prsDao;

	@Test
	public void testFindAll() {
		int number = prsDao.findAll().size();
		assertEquals(
				"The number of returned persons doesn't match the expected value",
				0, number);
	}

}
