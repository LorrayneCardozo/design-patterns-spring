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
