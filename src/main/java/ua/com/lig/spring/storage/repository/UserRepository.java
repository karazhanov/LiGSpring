package ua.com.lig.spring.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.lig.spring.storage.entity.User;

/**
 * @author karazhanov on 10.01.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
