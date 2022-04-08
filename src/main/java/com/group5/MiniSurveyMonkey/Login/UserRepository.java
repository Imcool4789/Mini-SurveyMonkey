package com.group5.MiniSurveyMonkey.Login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);

    User findByRoles(String roles);

    User findByUser(String user);
}
