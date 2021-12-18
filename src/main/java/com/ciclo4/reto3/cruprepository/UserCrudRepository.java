package com.ciclo4.reto3.cruprepository;


import com.ciclo4.reto3.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desarrolloextremo
 */

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findByMonthBirthtDay(String month);
}
