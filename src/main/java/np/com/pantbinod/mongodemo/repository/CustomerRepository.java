package np.com.pantbinod.mongodemo.repository;

import np.com.pantbinod.mongodemo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Object> {
}
