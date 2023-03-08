package designpatterns.lab.service;

import designpatterns.lab.entity.Address;
import designpatterns.lab.entity.Person;
import designpatterns.lab.repository.AddressRepository;
import designpatterns.lab.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return savePerson(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public Person update(Long id, Person person) {
        Person person1 = personRepository.findById(id).get();
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        person1.setCpf(person.getCpf());
        person1.setBirthDate(person.getBirthDate());
        person1.getAddress().setCep(person.getAddress().getCep());
        return savePerson(person1);
    }

    private Person savePerson(Person person) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = person.getAddress().getCep();

        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.queryCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        person.setAddress(address);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        return personRepository.save(person);
    }
}
