package ro.fiipractic.health.dao;

import java.util.List;
import ro.fiipractic.health.domain.Person;


public interface PersonDAO {
	
	public List<Person> findAll();
	
    public Person save(Person contact);
    
    public void delete(Person contact);
}
