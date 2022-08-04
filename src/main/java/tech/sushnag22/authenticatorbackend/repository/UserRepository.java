package tech.sushnag22.authenticatorbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.sushnag22.authenticatorbackend.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
