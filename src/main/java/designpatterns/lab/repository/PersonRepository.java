package designpatterns.lab.repository;

import designpatterns.lab.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class PersonRepository implements JpaRepository<Person, Long> {
}
