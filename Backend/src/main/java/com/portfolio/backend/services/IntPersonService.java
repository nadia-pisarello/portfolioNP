package com.portfolio.backend.services;

import com.portfolio.backend.models.Person;
import java.util.List;


public interface IntPersonService {
    public List<Person> getAllPersons();
    
    public Person person(Long id);
    
    public void savePerson(Person person);
    
    public void deletePerson(Long id);
    
}
