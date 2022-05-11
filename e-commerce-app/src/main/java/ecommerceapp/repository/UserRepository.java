package ecommerceapp.repository;

import ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByUserId(String userId);

    User findByUserId(String userId);

    User findByUserName(String userName);
}
