package designpatterns.lab.controller;

import designpatterns.lab.entity.Person;
import designpatterns.lab.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;


    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }


    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }
}
