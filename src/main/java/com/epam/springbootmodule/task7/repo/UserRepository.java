package com.epam.springbootmodule.task7.repo;

import com.epam.springbootmodule.task7.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Profile("test")
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findAllByName(String name);

}
