package designpatterns.lab.repository;

import designpatterns.lab.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AddressRepository implements JpaRepository<Address, String> {
}
